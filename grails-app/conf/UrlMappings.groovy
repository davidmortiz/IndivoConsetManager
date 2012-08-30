class UrlMappings {

	static mappings = {
        "/after_auth"(controller: 'CarraOAuth', action: 'callback')
        "/start_auth"(controller: 'CarraOAuth', action: 'authenticate')

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
