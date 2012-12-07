package org.indivohealth.data

import javax.xml.xpath.XPathFactory
import javax.xml.parsers.DocumentBuilderFactory
import org.indivohealth.exception.IndivoException

/**
 * @author David Ortiz
 * @date 9/4/12
 * @link http://cbmi.med.harvard.edu
 * @link http://chip.org
 *       <p/>
 *       NOTICE: This software comes with NO guarantees whatsoever and is
 *       licensed as Lgpl Open Source
 * @link http://www.gnu.org/licenses/lgpl.html
 */

class Demographic extends IndivoDocument<Demographic> {

  String dateOfBirth
  String email
  String gender
  String race
  String nameGiven
  String nameSuffix
  String nameFamily
  String namePrefix
  String ethnicity
  String language
  String adrStreet
  String adrCity
  String adrState
  String adrRegion
  String adrPostalcode
  String tel1Type
  String tel1Number
  String tel1Preferred
  String tel2Type
  String tel2Number
  String tel2Preferred

  //Other attributes
  String maritalStatus
  String employmentStatus
  String employmentIndustry
  String occupation
  String religion
  String income
  String highestEducation
  String organDonor

  public String getRecordType(){
      throw new IndivoException("Demographics shouldn't be coming back from Documents")
  }

  public static Demographic fromXML(Node n) {
    def docBuilderFactory = DocumentBuilderFactory.newInstance()
    def docBuilder = docBuilderFactory.newDocumentBuilder();
    def xpath = XPathFactory.newInstance().newXPath()


    return new Demographic(
        dateOfBirth:   sdmxFieldAsDate("bday", n),
        email:         sdmxFieldAsString("email", n),
        language:      sdmxFieldAsString("preferred_language",n),
        ethnicity:     sdmxFieldAsString("ethnicity",n),
        gender:        sdmxFieldAsString("gender",n),
        race:          sdmxFieldAsString("race",n),
        nameGiven:     sdmxFieldAsString("name_given", n),
        nameSuffix:    sdmxFieldAsString("name_suffix", n),
        nameFamily:    sdmxFieldAsString("name_family", n),
        namePrefix:    sdmxFieldAsString("name_prefix", n),
        tel1Type:      sdmxFieldAsString("tel_1_type", n),
        tel1Number:    sdmxFieldAsString("tel_1_number", n),
        tel1Preferred: sdmxFieldAsString("tel_1_preferred_p", n),
        tel2Type:      sdmxFieldAsString("tel_2_type", n),
        tel2Number:    sdmxFieldAsString("tel_2_number", n),
        tel2Preferred: sdmxFieldAsString("tel_2_preferred", n),
        adrRegion:     sdmxFieldAsString("adr_region", n),
        adrPostalcode: sdmxFieldAsString("adr_postalcode",n),
        adrStreet:     sdmxFieldAsString("adr_street",n),
        adrCity:       sdmxFieldAsString("adr_city", n),
        adrState:      sdmxFieldAsString("adr_state", n))

  }


    @Override
    String toXML() {
        throw new RuntimeException("Unimplemented")
    }
}
