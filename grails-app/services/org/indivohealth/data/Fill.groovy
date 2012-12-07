package org.indivohealth.data

import org.indivohealth.exception.IndivoException


class Fill extends IndivoDocument<Fill> {
    Date date
    String dispenseDaysSupply
    String pbm
    String pharmacyNcpdpid
    String pharmacyOrg
    String pharmacyAdrCountry
    String pharmacyAdrCity
    String pharmacyAdrPostalCode
    String pharmacyAdrStreet
    String providerDeaNumber
    String providerNpiNumber
    String providerEmail
    String providerNameGiven
    String providerNameFamily
    String providerTel1Type
    String providerTel1Number
    String providerTel1Preferred
    String quantityDispensedValue
    String quantityDispensedUnit

    public String getRecordType() { throw new IndivoException("Fills aren't first class record type") }


    public static Fill fromXML(Node n){
        new Fill(
            date:                   sdmxFieldAsDate("date", n),
            dispenseDaysSupply:     sdmxFieldAsString("dispenseDaysSupply", n),
            pbm:                    sdmxFieldAsString("pbm", n),
            pharmacyNcpdpid:        sdmxFieldAsString("pharmacy_ncpdpid", n),
            pharmacyOrg:            sdmxFieldAsString("pharmacy_org",n),
            pharmacyAdrCountry:     sdmxFieldAsString("pharmacy_adr_country", n),
            pharmacyAdrCity:        sdmxFieldAsString("pharmacy_adr_city", n),
            pharmacyAdrPostalCode:  sdmxFieldAsString("pharmacy_adr_postalcode", n),
            pharmacyAdrStreet:      sdmxFieldAsString("pharmacy_adr_street", n),
            providerDeaNumber:      sdmxFieldAsString("provider_dea_number",n),
            providerNpiNumber:      sdmxFieldAsString("provider_npi_number",n),
            providerEmail:          sdmxFieldAsString("provider_email",n),
            providerNameGiven:      sdmxFieldAsString("provider_name_given", n),
            providerNameFamily:     sdmxFieldAsString("provider_name_family", n),
            providerTel1Type:       sdmxFieldAsString("provider_tel_1_type", n),
            providerTel1Number:     sdmxFieldAsString("provider_tel_1_number", n),
            providerTel1Preferred:  sdmxFieldAsString("provider_tel_1_preferred_p", n),
            quantityDispensedValue: sdmxFieldAsString("quantityDispensed_value", n),
            quantityDispensedUnit:  sdmxFieldAsString("quantityDispensed_unit", n)
        )
    }

    def String toXML(){

        """<Model name="Fill">
           <Field name="date">${formatDate(date)}</Field>
           <Field name="dispenseDaysSupply">${dispenseDaysSupply}</Field>
           <Field name="pbm">${pbm}</Field>
           <Field name="pharmacy_ncpdpid">${pharmacyNcpdpid}</Field>
           <Field name="pharmacy_org">${pharmacyOrg}</Field>
           <Field name="pharmacy_adr_country">${pharmacyAdrCountry}</Field>
           <Field name="pharmacy_adr_city">${pharmacyAdrCity}</Field>
           <Field name="pharmacy_adr_postalcode">${pharmacyAdrPostalCode}</Field>
           <Field name="pharmacy_adr_street">${pharmacyAdrStreet}</Field>
           <Field name="provider_dea_number">${providerDeaNumber}</Field>
           <Field name="provider_npi_number">${providerNpiNumber}</Field>
           <Field name="provider_email">${providerEmail}</Field>
           <Field name="provider_name_given">${providerNameGiven}</Field>
           <Field name="provider_name_family">${providerNameFamily}</Field>
           <Field name="provider_tel_1_type">${providerTel1Type}</Field>
           <Field name="provider_tel_1_number">${providerTel1Number}</Field>
           <Field name="provider_tel_1_preferred_p">${providerTel1Preferred}</Field>
           <Field name="quantityDispensed_value">${quantityDispensedValue}</Field>
           <Field name="quantityDispensed_unit">${quantityDispensedUnit}</Field>
        </Model>"""
    }


}
