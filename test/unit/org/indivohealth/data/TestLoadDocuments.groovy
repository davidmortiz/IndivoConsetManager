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
        assert "AMITRIPTYLINE HCL 50 MG TAB" == d.drugNameTitle
        assert "http://purl.bioontology.org/ontology/RXNORM/" == d.drugNameSystem
        assert "856845" == d.drugNameIdentifier
        assert null != d.endDate
        assert null != d.startDate
        assert "2" == d.frequencyValue
        assert "/d" == d.frequencyUnit
        assert "Take two tablets twice daily as needed for pain" == d.instructions
        assert "Derived by prescription" == d.provenanceTitle
        assert "http://smartplatforms.org/terms/codes/MedicationProvenance#" == d.provenanceSystem
        assert "prescription" == d.provenanceIdentifier
        assert "2" == d.quantityValue
        assert "Unit" == d.quantityUnit
        assert d != null

        assert 2 == d.fills.size()
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
