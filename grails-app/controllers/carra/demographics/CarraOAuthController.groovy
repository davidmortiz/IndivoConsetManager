package carra.demographics

import carra.demographics.exception.BadRequestException

/**
 * This controller is a slight modification of the same class that comes with the Grails OAuth plugin
 */

class CarraOAuthController {

  IndivoService indivoService

  def callback = {
    //we have to pass in authToken so we can do a security check in the service
    indivoService.callback(params.oauth_token, params.oauth_verifier)
    redirect(controller: "demographic", action: "show")
  }



  def authenticate = {

    //figure out if we're
    String headerValue
    String id
    if(params.record_id) {
      headerValue = "record"
      id = params.record_id
    }
    else if(params.carenet_id) {
      headerValue = "carenet"
      id = params.carenet_id
    }

    //replace with a filter later
    try {
      def url = indivoService.beforeAuth(headerValue, id)
      return redirect(url: url.toString())
    }
    catch(BadRequestException e) {
      render(status: 403, text: "bad request")
    }

  }

}




