package carra.demographics

import carra.demographics.data.Demographic
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
import oauth.signpost.http.HttpResponse
import oauth.signpost.OAuth
import carra.demographics.data.BadRequestException
import carra.demographics.data.SecurityException

class IndivoService {
  static scope = "session"
  def grailsApplication


  private String token;
  private String secret;
  private String accessToken;

  private String recordType
  private String recordId


  public IndivoService(){

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
    if(recordType == "carenet") {
      httpPostVal = "indivo_carenet_id"
    }

    if(recordType == "record") {
      httpPostVal = "indivo_record_id"
    }

    provider.setListener(new OAuthProviderListener() {
      void prepareRequest(HttpRequest request) {
        HttpPost post = (HttpPost) request.unwrap()
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(httpPostVal) {
          nvps.add(new BasicNameValuePair(httpPostVal, id.toString()))
        }
        else {
          throw new BadRequestException("No carenet id or record id specified")
        }

        post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8))
      }

      void prepareSubmission(HttpRequest request) {

      }

      boolean onResponseReceived(HttpRequest request, HttpResponse response) {
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
    if(token != oauthToken) {
      throw new SecurityException("tokens don't match")
    }

    CommonsHttpOAuthProvider provider = createProvider()
    CommonsHttpOAuthConsumer consumer = createConsumer()
    consumer.setTokenWithSecret(token,secret)
    provider.setOAuth10a(true)
    String token = provider.retrieveAccessToken(consumer, OAuthVerifier)
    accessToken = token
    this.token = ""
    secret = ""

  }


  public Demographic getDemographics(String id) {
    def url = "${grailsApplication.config.indivo.backendUrl}/${recordType}s/${id}/demographics/"
    HttpGet get = new HttpGet(url)
  }



  private CommonsHttpOAuthConsumer createConsumer() {
    return new CommonsHttpOAuthConsumer(grailsApplication.config.indivo.consumerKey.toString(), grailsApplication.config.indivo.consumerSecret.toString())
  }


  private String request_token_url() {
    return "${grailsApplication.config.indivo.backendUrl}/oauth/request_token"
  }

  private String access_token_url() {
    return "${grailsApplication.config.indivo.backendUrl}/oauth/access_token"
  }

  private String authentication_url() {
    return "${grailsApplication.config.indivo.uiUrl}/oauth/authorize"
  }

  private CommonsHttpOAuthProvider createProvider() {
    return new CommonsHttpOAuthProvider(
            request_token_url(),
            access_token_url(),
            authentication_url())
  }


}
