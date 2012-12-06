package org.indivohealth.data

import javax.xml.parsers.DocumentBuilderFactory
import org.apache.commons.logging.LogFactory

class Consent extends IndivoData {
    private static final log = LogFactory.getLog(this)

    String identifier
    String studyName
    Date startDate
    Date endDate

    String toXML() {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    Consent fromXml(InputStream xmlInputStream) {
        try {
            def docBuilderFactory = DocumentBuilderFactory.newInstance()
            def docBuilder = docBuilderFactory.newDocumentBuilder();
            def xmlDocument = docBuilder.parse(xmlInputStream);


            Date startDate = sdmxFieldAsDate("startDate", xmlDocument)
            Date endDate = sdmxFieldAsDate("endDate", xmlDocument)

            def returnVal = new Consent(
                    identifier: sdmxFieldAsString("identifier", xmlDocument),
                    studyName: sdmxFieldAsString("studyName", xmlDocument),
                    startDate: startDate,
                    endDate: endDate
            )
            return returnVal
        }
        catch (Exception e) {
            log.fatal("Error reading in consent from XMLStream")
            return null
        }
        finally {
            xmlInputStream.close()

        }


    }
}
