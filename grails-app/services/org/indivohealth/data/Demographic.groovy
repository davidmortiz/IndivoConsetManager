package org.indivohealth.data

import javax.xml.xpath.XPathFactory

import javax.xml.xpath.XPathConstants
import javax.xml.parsers.DocumentBuilderFactory

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


  static String getRecordType(){ throw new RuntimeException("Special case") }

  public static Demographic fromXml(String string) {
    def docBuilderFactory = DocumentBuilderFactory.newInstance()
    def docBuilder = docBuilderFactory.newDocumentBuilder();
    def xmlDocument = docBuilder.parse(string);

    def xpath = XPathFactory.newInstance().newXPath()

    return new Demographic(
    dateOfBirth: (String) xpath.evaluate("/Models/Model/Field[@name='bday']/text()",xmlDocument, XPathConstants.STRING),
    email: (String) xpath.evaluate("/Models/Model/Field[@name='email']/text()",xmlDocument, XPathConstants.STRING),
    language: (String) xpath.evaluate("/Models/Model/Field[@name='preferred_language']/text()",xmlDocument, XPathConstants.STRING),
    ethnicity: (String) xpath.evaluate("/Models/Model/Field[@name='ethnicity']/text()",xmlDocument, XPathConstants.STRING),
    gender: (String) xpath.evaluate("/Models/Model/Field[@name='gender']/text()",xmlDocument, XPathConstants.STRING),
    race: (String) xpath.evaluate("/Models/Model/Field[@name='race']/text()",xmlDocument, XPathConstants.STRING),
    nameGiven: (String) xpath.evaluate("/Models/Model/Field[@name='name_given']/text()",xmlDocument, XPathConstants.STRING),
    nameSuffix: (String) xpath.evaluate("/Models/Model/Field[@name='name_suffix']/text()",xmlDocument, XPathConstants.STRING),
    nameFamily: (String) xpath.evaluate("/Models/Model/Field[@name='name_family']/text()",xmlDocument, XPathConstants.STRING),
    namePrefix: (String) xpath.evaluate("/Models/Model/Field[@name='name_prefix']/text()",xmlDocument, XPathConstants.STRING),
    tel1Type: (String) xpath.evaluate("/Models/Model/Field[@name='tel_1_type']/text()",xmlDocument, XPathConstants.STRING),
    tel1Number: (String) xpath.evaluate("/Models/Model/Field[@name='tel_1_number']/text()",xmlDocument, XPathConstants.STRING),
    tel1Preferred: (String) xpath.evaluate("/Models/Model/Field[@name='tel_1_preferred_p']/text()",xmlDocument, XPathConstants.STRING),
    tel2Type: (String) xpath.evaluate("/Models/Model/Field[@name='tel_2_type']/text()",xmlDocument, XPathConstants.STRING) ,
    tel2Number: (String) xpath.evaluate("/Models/Model/Field[@name='tel_2_number']/text()",xmlDocument, XPathConstants.STRING),
    tel2Preferred: (String) xpath.evaluate("/Models/Model/Field[@name='tel_2_preferred']/text()",xmlDocument, XPathConstants.STRING) ,
    adrRegion: (String) xpath.evaluate("/Models/Model/Field[@name='adr_region']/text()",xmlDocument, XPathConstants.STRING) ,
    adrPostalcode: (String) xpath.evaluate("/Models/Model/Field[@name='adr_postalcode']/text()",xmlDocument, XPathConstants.STRING),
    adrStreet: (String) xpath.evaluate("/Models/Model/Field[@name='adr_street']/text()",xmlDocument, XPathConstants.STRING),
    adrCity: (String) xpath.evaluate("/Models/Model/Field[@name='adr_city']/text()",xmlDocument, XPathConstants.STRING)  ,
    adrState: (String) xpath.evaluate("/Models/Model/Field[@name='adr_state']/text()",xmlDocument, XPathConstants.STRING))

  }


    @Override
    String toXML() {
        throw new RuntimeException("Unimplemented")
    }
}
