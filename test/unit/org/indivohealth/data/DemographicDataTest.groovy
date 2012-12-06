package org.indivohealth.data

import org.indivohealth.data.Demographic
import org.junit.Test

/**
 * @author David Ortiz
 * @date 9/6/12
 * @link http://cbmi.med.harvard.edu
 * @link http://chip.org
 *       <p/>
 *       NOTICE: This software comes with NO guarantees whatsoever and is
 *       licensed as Lgpl Open Source
 * @link http://www.gnu.org/licenses/lgpl.html
 */

import grails.test.mixin.TestFor

@TestFor(Demographic)
class DemographicDataTest {

  @Test
  void testDemographics() {
    String xml = '''

    <Models>
        <Model name="Demographics" documentId="44190967-cbaa-43a7-a98c-9f97f094ef2b">
            <Field name="bday">1965-08-09</Field>
            <Field name="email">william.robinson@example.com</Field>
            <Field name="ethnicity">dave</Field>
            <Field name="gender">male</Field>
            <Field name="preferred_language">EN</Field>
            <Field name="race">purple</Field>
            <Field name="name_given">Robinson</Field>
            <Field name="name_suffix">Sr.</Field>
            <Field name="name_family">William</Field>
            <Field name="name_prefix">Sir</Field>
            <Field name="tel_2_type">h</Field>
            <Field name="tel_2_preferred_p">True</Field>
            <Field name="tel_2_number">800-870-3011</Field>
            <Field name="adr_region">OK</Field>
            <Field name="adr_country">USA</Field>
            <Field name="adr_postalcode">74008</Field>
            <Field name="adr_city">Bixby</Field>
            <Field name="adr_street">23 Church Rd</Field>
            <Field name="tel_1_type">h</Field>
            <Field name="tel_1_preferred_p">True</Field>
            <Field name="tel_1_number">800-870-3011</Field>
        </Model>
    </Models>
    '''

    def inputStream = new ByteArrayInputStream(xml.bytes)
    def d = Demographic.fromXml(inputStream)

    assert d.dateOfBirth == "1965-08-09"
    assert d.email == "william.robinson@example.com"
    assert d.gender == "male"
    assert d.ethnicity == "dave"
    assert d.language == "EN"
    assert d.race == "purple"
    assert d.nameGiven =="Robinson"
    assert d.nameSuffix == "Sr."
    assert d.nameFamily == "William"
    assert d.namePrefix == "Sir"
    assert d.tel1Type == "h"
    assert d.tel1Number ==  "800-870-3011"
    assert d.tel1Preferred == "True"
    assert d.adrCity ==  "Bixby"
    assert d.adrPostalcode == "74008"


  }

}
