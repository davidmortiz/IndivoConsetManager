package carra.demographics


import oauth.signpost.OAuthConsumer
import oauth.signpost.basic.DefaultOAuthConsumer
import oauth.signpost.OAuthProvider
import oauth.signpost.basic.DefaultOAuthProvider
import oauth.signpost.OAuth
import oauth.signpost.OAuthProviderListener
import oauth.signpost.http.HttpRequest
import oauth.signpost.http.HttpResponse

/**
 * This controller is a slight modification of the same class that comes with the Grails OAuth plugin
 */

class CarraOAuthController {

    private String REQUEST_TOKEN_URL = "http://sandbox.indivohealth.org:8000/oauth/request_token"
    private String ACCESS_TOKEN_URL = "http://sandbox.indivohealth.org:8000/oauth/access_token"
    private String AUTHENTICATION_URL = "http://sandbox.indivohealth.org/oauth/authorize"

    private OAuthConsumer consumer = new DefaultOAuthConsumer("sampleweb@apps.indivo.org", "yourwebapp")


    def callback = {
        String recordId = params.record_id
        String carenetId = params.carenet_id


        OAuthProvider provider = new DefaultOAuthProvider(
                REQUEST_TOKEN_URL,
                ACCESS_TOKEN_URL,
                AUTHENTICATION_URL)

        provider.retrieveAccessToken(consumer, verifier)

        render("WORKK")
    }



    def authenticate = {
        String recordId = params.record_id
        String carenetId = params.carenet_id

        String requestTokenURL = null

        //IndivoX requires us to pass record_id or carenet_id on the authorization
        //for OAUTH
        if (recordId.length() > 0) {
            requestTokenURL = REQUEST_TOKEN_URL //+ "?indivo_record_id=${recordId}"
        }
        else if (carenetId.length() > 0) {
            requestTokenURL = REQUEST_TOKEN_URL
        }

        OAuthProvider provider = new DefaultOAuthProvider(
                requestTokenURL,
                ACCESS_TOKEN_URL,
                AUTHENTICATION_URL + "?indivo_record_id=${recordId}")

        provider.setOAuth10a(true)

        String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND)
        return redirect(url: authUrl)
    }

}




