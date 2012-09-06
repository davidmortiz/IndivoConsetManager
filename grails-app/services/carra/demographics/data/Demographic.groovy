package carra.demographics.data

import org.apache.commons.io.IOUtils
import javax.xml.xpath.XPathFactory
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilder
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

class Demographic {

  Date dateOfBirth
  Date dataOfDeath
  String gender
  String ethnicity
  String language
  String maritalStatus
  String employmentStatus
  String employmentIndustry
  String occupation
  String religion
  String income
  String highestEducation
  String organDonor


  public static Demographic fromXml(InputStream xmlStream) {
//    StringWriter writer = new StringWriter();
//    IOUtils.copy(xmlStream, writer, "utf-8");
//    String theString = writer.toString();

    def docBuilderFactory = DocumentBuilderFactory.newInstance()
    def docBuilder = docBuilderFactory.newDocumentBuilder();
    def xmlDocument = docBuilder.parse(xmlStream);

    def xpath = XPathFactory.newInstance().newXPath()
    def bday = (String) xpath.evaluate("/Mode/Field/@name=bday",xmlDocument, XPathConstants.STRING)
    def email = (String) xpath.evaluate("/Mode/Field/@name=email",xmlDocument, XPathConstants.STRING)


    return null
  }


}
