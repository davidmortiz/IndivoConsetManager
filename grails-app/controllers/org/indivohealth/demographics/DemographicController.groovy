package org.indivohealth.demographics

import org.indivohealth.data.Demographic
import org.indivohealth.IndivoService

class DemographicController {
  IndivoService indivoService

  def index() { }

  def show = {
    Demographic d = indivoService.getDemographics()
    [demographic: d]

  }
}


