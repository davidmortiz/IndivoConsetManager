package org.indivohealth.data

import javax.xml.xpath.XPathFactory
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat
import org.joda.time.DateTime
import org.indivohealth.exception.IndivoException


public abstract class IndivoDocument<T extends IndivoDocument> {

    static def xpath = XPathFactory.newInstance().newXPath()

    abstract public String toXML()

    //every document has an IndivoID
    String indivoId

    public abstract getRecordType()


    static protected String sdmxFieldAsString(String fieldName, Node modelNode) {
        return modelNode.find { it.'@name' == fieldName }?.text()


    }


    static protected Date sdmxFieldAsDate(String fieldName, Node modelNode) {
        DateTimeFormatter parser2 = ISODateTimeFormat.dateTimeNoMillis()
        String date = sdmxFieldAsString(fieldName, modelNode)
        if (date == null || date == "") {
            return null
        }

        DateTime dt = parser2.parseDateTime(date)
        return dt.toDate()


    }

    private static String documentIdFromModelNode(Node modelNode) {
        return modelNode.attribute("documentId")
    }

    private static String getDocumentType(Node modelNode) {
        return modelNode.attribute("name")
    }

    protected static String formatDate(Date d) {
        if(d == null) return null
        DateTime dt = new DateTime(d)
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        return fmt.print(dt);
    }

    public static List<IndivoDocument> LoadModels(String XML) {
        try {
            def returnList = new ArrayList<IndivoDocument>()
            def records = new XmlParser().parseText(XML)
            def models = records.Model

            for (i in models) {
                def documentType = getDocumentType(i)
                IndivoDocument d = null;
                switch (documentType) {
                    case "Consent":
                        d = Consent.fromXML(i)
                        break
                    case "Medication":
                        d = Medication.fromXML(i)
                        break
                    default:
                        break
                }
                d?.setIndivoId(documentIdFromModelNode(i))
                returnList.add(d)
            }
            return returnList
        } catch (Exception e) {
            throw new IndivoException("Bad response from server", e)
        }


    }


}