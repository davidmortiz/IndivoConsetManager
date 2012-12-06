# mkdir ${indivo_server_home}/indivo/data_models/contrib/consent
# Put this file in ${indivo_server_home}/indivo/data_models/contrib/consent
#
#

from indivo.models import Fact
from django.db import models


class Consent(Fact):
    identifier = models.CharField(max_length=255, null=False)
    study_name = models.CharField(max_length=255, null=False)
    start_date = models.DateField(null=False)
    end_date = models.DateField(null=True)

