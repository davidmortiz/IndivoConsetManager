package org.indivohealth.data


class Medication extends IndivoDocument<Medication> {
    String drugNameTitle
    String drugNameSystem
    String drugNameIdentifier
    Date startDate
    Date endDate
    String frequencyValue
    String frequencyUnit
    String instructions
    String provenanceTitle
    String provenanceSystem
    String provenanceIdentifier
    String quantityValue
    String quantityUnit

    List<Fill> fills

    public static final String RECORD_TYPE = "Medication"

    @Override
    public String getRecordType() {RECORD_TYPE}

    @Override
    String toXML() {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    static Medication fromXML(Node n) {
        List<Fill> fills = new ArrayList<Fill>()
        for (i in n.Field.Models.Model) {
            fills.add(Fill.fromXML(i))
        }

        new Medication(
                fills: fills,
                drugNameTitle: sdmxFieldAsString("drugName_title", n),
                drugNameSystem: sdmxFieldAsString("drugName_system", n),
                drugNameIdentifier: sdmxFieldAsString("drugName_identifier", n),
                endDate: sdmxFieldAsDate("endDate", n),
                frequencyUnit: sdmxFieldAsString("frequency_unit", n),
                frequencyValue: sdmxFieldAsString("frequency_value", n),
                instructions: sdmxFieldAsString("instructions", n),
                provenanceTitle: sdmxFieldAsString("provenance_title", n),
                provenanceSystem: sdmxFieldAsString("provenance_system", n),
                provenanceIdentifier: sdmxFieldAsString("provenance_identifier", n),
                quantityValue: sdmxFieldAsString("quantity_value", n),
                quantityUnit: sdmxFieldAsString("quantity_unit", n),
                startDate: sdmxFieldAsDate("startDate", n)
        )


    }
}
