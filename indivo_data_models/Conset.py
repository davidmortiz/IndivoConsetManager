from indivo.models import Fact
from django.db import models
from indivo.fields import CodedValueField, ValueAndUnitField, PharmacyField, ProviderField

class Consent(Fact):
    identifier = models.CharField(max_length=255, null=True)
    studyName = models.CharField(max_length=255, null=True)
    startDate = models.DateField(null=True)
    endDate = models.DateField(null=True)

