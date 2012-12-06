# mkdir ${indivo_server_home}/indivo/data_models/contrib/consent
# Put this file in ${indivo_server_home}/indivo/data_models/contrib/consent
#
#

from indivo.models import Fact
from django.db import models


class Consent(Fact):
    identifier = models.CharField(max_length=255, null=False)
    studyName = models.CharField(max_length=255, null=False)
    startDate = models.DateField(null=False)
    endDate = models.DateField(null=True)

