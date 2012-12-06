package org.indivohealth.data

import javax.xml.xpath.XPathFactory
import org.w3c.dom.Document
import javax.xml.xpath.XPathConstants
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat
import org.joda.time.DateTime


public abstract class IndivoData {
    abstract public String toXML();

    def xpath = XPathFactory.newInstance().newXPath()




    protected String sdmxFieldAsString(String fieldName, Document doc){
        return (String) xpath.evaluate("/Models/Model/Field[@name='${fieldName}']/text()",
                                        doc,
                                        XPathConstants.STRING)
    }

    protected Date sdmxFieldAsDate(String fieldName, Document doc){
        DateTimeFormatter parser2 = ISODateTimeFormat.dateTimeNoMillis()
        String date = sdmxFieldAsString(fieldName, doc)
        if(date == null || date == ""){
            return null
        }

        DateTime dt = parser2.parseDateTime(date)
        return dt.toDate()


    }



}