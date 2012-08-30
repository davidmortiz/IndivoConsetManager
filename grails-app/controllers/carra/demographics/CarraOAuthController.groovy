package carra.demographics

import oauth.signpost.OAuth
import oauth.signpost.OAuthProviderListener
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider
import oauth.signpost.http.HttpRequest
import oauth.signpost.http.HttpResponse
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.message.BasicNameValuePair
import org.apache.http.protocol.HTTP

/**
 * This controller is a slight modification of the same class that comes with the Grails OAuth plugin
 */

class CarraOAuthController {

  private String REQUEST_TOKEN_URL = "http://a:8000/oauth/request_token"
  private String ACCESS_TOKEN_URL = "http://a:8000/oauth/access_token"
  private String AUTHENTICATION_URL = "http://a:8080/oauth/authorize"

  def callback = {
    String recordId = params.record_id
    String carenetId = params.carenet_id

    String token = session["token"]
    String secret = session["secret"]

    if(token != params.oauth_token){
      render(text: "Tokens don't match, rogue Indivo detected", status: 403)
    }

    CommonsHttpOAuthConsumer consumer = new CommonsHttpOAuthConsumer("sampleweb@apps.indivo.org", "yourwebapp")
    CommonsHttpOAuthProvider provider = new CommonsHttpOAuthProvider(
            REQUEST_TOKEN_URL,
            ACCESS_TOKEN_URL,
            AUTHENTICATION_URL)

    consumer.setTokenWithSecret(token,secret)
    provider.setOAuth10a(true)
    String accessToken = provider.retrieveAccessToken(consumer, params.oauth_verifier)
    render("WORKK")
  }



  def authenticate = {
    String recordId = params.record_id
    String carenetId = params.carenet_id
    String requestTokenURL = null

    CommonsHttpOAuthConsumer consumer = new CommonsHttpOAuthConsumer("sampleweb@apps.indivo.org", "yourwebapp")


    CommonsHttpOAuthProvider provider = new CommonsHttpOAuthProvider(
            REQUEST_TOKEN_URL,
            ACCESS_TOKEN_URL,
            AUTHENTICATION_URL)




    provider.setListener(new OAuthProviderListener() {
      void prepareRequest(HttpRequest request) {
          HttpPost post = (HttpPost) request.unwrap()
          List<NameValuePair> nvps = new ArrayList<NameValuePair>();
          nvps.add(new BasicNameValuePair("indivo_record_id", recordId.toString()))
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
    session["token"] = consumer.getToken()
    session["secret"]  = consumer.getTokenSecret()

    return redirect(url: authUrl)
  }

}




