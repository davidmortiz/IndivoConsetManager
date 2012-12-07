package org.indivohealth.data

import grails.test.mixin.TestFor
import org.junit.Test

@TestFor(IndivoDocument)
class TestLoadDocuments {

    @Test
    void testLoadMedication() {
        def resultList = IndivoDocument.LoadModels(CONSTANTS.TEST_DOC_MEDICATION)
        assert 1 == resultList.size()
        Medication d = (Medication) resultList.get(0)
        assert d != null
    }

    @Test
    void testLoadConsent() {
        def resultList = IndivoDocument.LoadModels(CONSTANTS.TEST_DOC_CONSENT)
        assert 1 == resultList.size()
        Consent c = (Consent) resultList.get(0)
        assert c != null
        assert "StudyID" == c.studyIdentifier
        assert "TestStudy 1" == c.studyName
        assert c.startDate != null
        assert c.endDate != null

    }
}
