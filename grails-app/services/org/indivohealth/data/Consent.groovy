package org.indivohealth.data

import javax.xml.parsers.DocumentBuilderFactory
import org.apache.commons.logging.LogFactory
import org.joda.time.DateTime

class Consent extends IndivoDocument<Consent> {
    private static final log = LogFactory.getLog(this)
    public static final String RECORD_TYPE = "consent"

    String studyIdentifier
    String studyName
    Date startDate
    Date endDate

    static String getRecordType(){ RECORD_TYPE }

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

    static Consent fromXml(String docString) {
        try {
            def docBuilderFactory = DocumentBuilderFactory.newInstance()
            def docBuilder = docBuilderFactory.newDocumentBuilder();
            def xmlDocument = docBuilder.parse(docString);

            Date startDate = sdmxFieldAsDate("start_date", xmlDocument)
            Date endDate = sdmxFieldAsDate("end_date", xmlDocument)

            def returnVal = new Consent(
                    studyIdentifier: sdmxFieldAsString("study_identifier", xmlDocument),
                    studyName: sdmxFieldAsString("studyName", xmlDocument),
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
