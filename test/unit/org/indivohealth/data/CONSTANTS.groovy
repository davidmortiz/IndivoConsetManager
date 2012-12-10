package org.indivohealth.data

import org.joda.time.DateTime

/**
 * Created with IntelliJ IDEA.
 * User: daveortiz
 * Date: 12/7/12
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
class CONSTANTS {

    public static final String TEST_DOC_MEDICATION =
        """
<Models>
  <Model name="Medication">
    <Field name="drugName_title">AMITRIPTYLINE HCL 50 MG TAB</Field>
    <Field name="drugName_system">http://purl.bioontology.org/ontology/RXNORM/</Field>
    <Field name="drugName_identifier">856845</Field>
    <Field name="endDate">2007-04-14T04:00:00Z</Field>
    <Field name="frequency_value">2</Field>
    <Field name="frequency_unit">/d</Field>
    <Field name="instructions">Take two tablets twice daily as needed for pain</Field>
    <Field name="provenance_title">Derived by prescription</Field>
    <Field name="provenance_system">http://smartplatforms.org/terms/codes/MedicationProvenance#</Field>
    <Field name="provenance_identifier">prescription</Field>
    <Field name="quantity_value">2</Field>
    <Field name="quantity_unit">Unit</Field>
    <Field name="startDate">2007-04-14T04:00:00Z</Field>
    <Field name="fulfillments">
      <Models>
        <Model name="Fill">
          <Field name="date">2007-03-14T04:00:00Z</Field>
          <Field name="dispenseDaysSupply">30</Field>
          <Field name="pbm">T00000000001011</Field>
          <Field name="pharmacy_ncpdpid">5235235</Field>
          <Field name="pharmacy_org">CVS #588</Field>
          <Field name="pharmacy_adr_country">Australia</Field>
          <Field name="pharmacy_adr_city">WonderCity</Field>
          <Field name="pharmacy_adr_postalcode">5555</Field>
          <Field name="pharmacy_adr_street">111 Lake Drive</Field>
          <Field name="provider_dea_number">325555555</Field>
          <Field name="provider_npi_number">5235235</Field>
          <Field name="provider_email">joshua.mandel@fake.emailserver.com</Field>
          <Field name="provider_name_given">Josuha</Field>
          <Field name="provider_name_family">Mandel</Field>
          <Field name="provider_tel_1_type">w</Field>
          <Field name="provider_tel_1_number">1-235-947-3452</Field>
          <Field name="provider_tel_1_preferred_p">true</Field>
          <Field name="quantityDispensed_value">60</Field>
          <Field name="quantityDispensed_unit">{tablet}</Field>
        </Model>
        <Model name="Fill">
          <Field name="date">2007-04-14T04:00:00Z</Field>
          <Field name="dispenseDaysSupply">30</Field>
          <Field name="pbm">T00000000001011</Field>
          <Field name="pharmacy_ncpdpid">5235235</Field>
          <Field name="pharmacy_org">CVS #588</Field>
          <Field name="pharmacy_adr_country">Australia</Field>
          <Field name="pharmacy_adr_city">WonderCity</Field>
          <Field name="pharmacy_adr_postalcode">5555</Field>
          <Field name="pharmacy_adr_street">111 Lake Drive</Field>
          <Field name="provider_dea_number">325555555</Field>
          <Field name="provider_npi_number">5235235</Field>
          <Field name="provider_email">joshua.mandel@fake.emailserver.com</Field>
          <Field name="provider_name_given">Josuha</Field>
          <Field name="provider_name_family">Mandel</Field>
          <Field name="provider_tel_1_type">w</Field>
          <Field name="provider_tel_1_number">1-235-947-3452</Field>
          <Field name="provider_tel_1_preferred_p">true</Field>
          <Field name="quantityDispensed_value">60</Field>
          <Field name="quantityDispensed_unit">{tablet}</Field>
        </Model>
      </Models>
    </Field>
  </Model>
</Models>
        """

    public static final String TEST_DOC_CONSENT =
        """
          <Models xmlns="http://indivo.org/vocab/xml/documents#">
                     <Model name="Consent" >
                       <Field name="study_identifier">StudyID</Field>
                       <Field name="study_name">TestStudy 1</Field>
                       <Field name="start_date">2004-11-05T08:15:30-05:00</Field>
                       <Field name="end_date">2004-11-05T08:15:30-05:00</Field>
                     </Model>
                   </Models>
    """


    public static final TEST_DOC_DEMOGRAPHIC =  '''
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


}
