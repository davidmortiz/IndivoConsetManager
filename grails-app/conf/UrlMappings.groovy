class UrlMappings {

  static mappings = {
    "/after_auth"(controller: 'CarraOAuth', action: 'callback')
    "/start_auth"(controller: 'CarraOAuth', action: 'authenticate')
    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }

    "/"(view: "/index")
    "500"(view: '/error')
  }
}
