package org.indivohealth.data

import org.apache.commons.logging.LogFactory


class ResponseMetadata extends IndivoDocument<ResponseMetadata> {
    private static final log = LogFactory.getLog(this)


    public String getRecordType(){ throw new RuntimeException("No record id on this type of doc") }

    String toXML() {
        throw new RuntimeException("BLAH")
    }

    static ResponseMetadata fromXML(String docString) {
       return null
    }

}


