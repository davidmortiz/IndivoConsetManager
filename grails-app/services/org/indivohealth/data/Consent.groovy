package org.indivohealth.data

import org.apache.commons.logging.LogFactory
import org.joda.time.DateTime

class Consent extends IndivoDocument<Consent> {
    private static final log = LogFactory.getLog(this)

    public static String recordType = "Consent"

    public getRecordType() { return recordType }



    String studyIdentifier
    String studyName
    Date startDate
    Date endDate

    @Override
    String toXML() {
        DateTime dtStartDate = new DateTime(startDate)
        DateTime dtEndDate = null

        if(endDate != null && endDate != ""){
            dtEndDate = new DateTime(endDate)
        }

        def xml = """
                   <Models xmlns="http://indivo.org/vocab/xml/documents#">
                     <Model name="TestMedication" >
                       <Field name="study_identifier">${studyIdentifier}{</Field>
                       <Field name="study_name">${studyName}</Field>
                       <Field name="start_date">${dtStartDate.toString()}</Field>
                       <Field name="end_date">${dtEndDate?.toString()}</Field>
                     </Model>
                    </Models>
                """
        return xml
    }

    static Consent fromXML(Node n) {
        try {


            Date startDate = sdmxFieldAsDate("start_date", n)
            Date endDate = sdmxFieldAsDate("end_date", n)

            def returnVal = new Consent(
                    studyIdentifier: sdmxFieldAsString("study_identifier", n),
                    studyName: sdmxFieldAsString("study_name", n),
                    startDate: startDate,
                    endDate: endDate
            )
            return returnVal
        }
        catch (Exception e) {
            e.printStackTrace()
            log.fatal("Error reading in consent from XMLStream")
            return null
        }
    }
}
