package carra.demographics

import carra.demographics.data.Demographic


class DemographicController {
  IndivoService indivoService

  def index() { }

  def show = {
    Demographic d = indivoService.getDemographics()
    [demographic: d]

  }
}


