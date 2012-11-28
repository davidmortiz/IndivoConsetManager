package indivo.demographics

import carra.demographics.data.Demographic
import carra.demographics.IndivoService


class DemographicController {
  IndivoService indivoService

  def index() { }

  def show = {
    Demographic d = indivoService.getDemographics()
    [demographic: d]

  }
}


