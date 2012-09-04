package carra.demographics

import carra.demographics.data.Demographic


class DemographicController {
  IndivoService indivoService

  def index() { }

  def show = {
    def id = session[CarraOAuthController.ID_KEY]
    Demographic d = indivoService.getDemographics(id)
    [demographic: d]

  }
}


