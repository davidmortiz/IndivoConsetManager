package carra.demographics

import carra.demographics.data.Demographic
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

import static org.junit.Test.*
import grails.test.mixin.TestFor

@TestFor(Demographic)
class DemographicDataTest {

  @Test
  def testDemographics() {
    String xml = '''
       <Models>
        <Model name="Demographics" documentId="9b4e94b9-6705-4eb5-9a7f-ffb6b646dcbe">
          <Field name="bday">1939-11-15</Field>
          <Field name="email">test@test.com</Field>
          <Field name="ethnicity"/>
          <Field name="gender">female</Field><Field name="preferred_language"/
          <Field name="race"/>
          <Field name="name_given">test</Field>
          <Field name="name_prefix"/>
          <Field name="name_suffix"/>
          <Field name="name_family">test</Field>
          <Field name="name_middle"/>
          <Field name="tel_2_type"/>
          <Field name="tel_2_preferred_p">false</Field>
          <Field name="tel_2_number"/><Field name="adr_region"/><Field name="adr_country"/>
          <Field name="adr_postalcode"/>
          <Field name="adr_city"/><Field name="adr_street"/>
          <Field name="tel_1_type"/>
          <Field name="tel_1_preferred_p">false</Field><Field name="tel_1_number"/>
        </Model>
    </Models>
    '''

    def inputStream = new ByteArrayInputStream(xml.bytes)
    def d = Demographic.fromXml(inputStream)


  }

}
