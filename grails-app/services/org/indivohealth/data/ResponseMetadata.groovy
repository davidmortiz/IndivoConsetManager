package org.indivohealth.data

import org.apache.commons.logging.LogFactory
import javax.xml.parsers.DocumentBuilderFactory


class ResponseMetadata extends IndivoDocument<ResponseMetadata> {
    private static final log = LogFactory.getLog(this)


    public String getRecordType(){ throw new RuntimeException("No record id on this type of doc") }

    String toXML() {
        throw new RuntimeException("BLAH")
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


