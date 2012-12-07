package org.indivohealth.data


class Medication extends IndivoDocument<Medication> {
    String dugNameTitle
    String drugNameSystem
    String drugNameIdentifier
    Date endDate
    String frequencyValue
    String frequencyUunit
    String instructions
    String provenanceTitle
    String provenanceSystem
    String provenanceIdentifier
    String quantityValue
    String quantityUnit

    public static final String RECORD_TYPE = "Medication"

    @Override
    public String getRecordType() {RECORD_TYPE}

    @Override
    String toXML() {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    static Medication fromXML(Node n){

    }
}
