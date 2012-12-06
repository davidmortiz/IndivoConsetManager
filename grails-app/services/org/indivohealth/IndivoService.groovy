package org.indivohealth

import org.apache.http.client.methods.HttpGet
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider
import oauth.signpost.OAuthProviderListener
import oauth.signpost.http.HttpRequest
import org.apache.http.client.methods.HttpPost
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.protocol.HTTP
import oauth.signpost.OAuth
import org.indivohealth.exception.BadRequestException
import org.indivohealth.exception.SecurityException
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.client.HttpClient
import org.apache.http.HttpResponse

import org.indivohealth.data.Demographic
import org.indivohealth.exception.IndivoException
import org.indivohealth.data.IndivoDocument
import org.apache.http.client.methods.HttpRequestBase
import org.apache.commons.io.IOUtils

class IndivoService {
    static scope = "session"
    def grailsApplication


    private String token;
    private String secret;

    private String recordType
    private String recordId



    public IndivoService() {

    }

    /**
     * First half of the OAuth Dance
     * @param recordType record or carenet
     * @param id
     * @return
     */
    def URL beforeAuth(String recordType, String id) {
        this.recordId = id
        this.recordType = recordType

        CommonsHttpOAuthConsumer consumer = createConsumer()
        CommonsHttpOAuthProvider provider = createProvider()


        String httpPostVal
        if (recordType == "carenet") {
            httpPostVal = "indivo_carenet_id"
        }

        if (recordType == "record") {
            httpPostVal = "indivo_record_id"
        }

        provider.setListener(new OAuthProviderListener() {
            void prepareRequest(HttpRequest request) {
                HttpPost post = (HttpPost) request.unwrap()
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                if (httpPostVal) {
                    nvps.add(new BasicNameValuePair(httpPostVal, id.toString()))
                }
                else {
                    throw new BadRequestException("No carenet id or record id specified")
                }

                post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8))
            }

            void prepareSubmission(HttpRequest request) {

            }

            boolean onResponseReceived(HttpRequest request, oauth.signpost.http.HttpResponse response) {
                return false
            }
        });

        provider.setOAuth10a(true)
        String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND)
        token = consumer.getToken()
        secret = consumer.getTokenSecret()
        return new URL(authUrl)
    }

    def callback(String oauthToken, String OAuthVerifier) {
        if (token != oauthToken) {
            throw new SecurityException("tokens don't match")
        }

        CommonsHttpOAuthProvider provider = createProvider()
        CommonsHttpOAuthConsumer consumer = createConsumer()
        consumer.setTokenWithSecret(token, secret)
        provider.setOAuth10a(true)
        provider.retrieveAccessToken(consumer, OAuthVerifier)
        token = consumer.getToken()
        secret = consumer.getTokenSecret()

    }

    public <T extends IndivoDocument> T getDocumentById(T t, String id) {
        String url = baseUrl() + "/documents/${id}"
        HttpGet get = new HttpGet(url)
        String result = makeIndivoRequest(get)
        T returnVal = (T) T.fromXml(result)
        return returnVal
    }



    public Demographic getDemographics() {
        String url = baseUrl() + "/demographics?response_format=application/xml"
        HttpGet get = new HttpGet(url)
        String result = makeIndivoRequest(get)
        return Demographic.fromXml(result) ;

    }




    private String makeIndivoRequest(HttpRequestBase method) {
        HttpClient client = new DefaultHttpClient()
        HttpResponse response = null;
        try {
            CommonsHttpOAuthConsumer consumer = createConsumer()
            consumer.setTokenWithSecret(token, secret)
            consumer.sign(method)
            response = client.execute(method)
            int statusCode = response.getStatusLine().statusCode

            if(statusCode == 404 || statusCode == 403) {
                log.fatal("Document not found at ${method.getURI()}")
                return null
            }
            if (response.getStatusLine().statusCode != 200) {
                throw new IndivoException("Unknown error")
            }
            StringWriter writer = new StringWriter();
            IOUtils.copy(response.entity.content, writer, "UTF-8");
            return writer.toString();
        }
        finally {
            response?.entity?.content?.close()
            client.connectionManager.shutdown()
        }

    }


    private String baseUrl() {
        "${grailsApplication.config.org.indivohealth.backendUrl}/${recordType}s/${recordId}"
    }



    private CommonsHttpOAuthConsumer createConsumer() {
        return new CommonsHttpOAuthConsumer(grailsApplication.config.org.indivohealth.consumerKey.toString(), grailsApplication.config.org.indivohealth.consumerSecret.toString())
    }


    private String request_token_url() {
        return "${grailsApplication.config.org.indivohealth.backendUrl}/oauth/request_token"
    }

    private String access_token_url() {
        return "${grailsApplication.config.org.indivohealth.backendUrl}/oauth/access_token"
    }

    private String authentication_url() {
        return "${grailsApplication.config.org.indivohealth.uiUrl}/oauth/authorize"
    }

    private CommonsHttpOAuthProvider createProvider() {
        return new CommonsHttpOAuthProvider(
                request_token_url(),
                access_token_url(),
                authentication_url())
    }

}
