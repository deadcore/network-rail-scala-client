package io.igu.networkrail.model

sealed trait TrainMovementTopic {
  val topic: String
}

object TrainMovementTopic {

  object AllTrainOperatingCompanies extends TrainMovementTopic {
    val topic: String = "TRAIN_MVT_ALL_TOC"
  }

  object AllNonPassengerTrainOperatingCompanyMovements extends TrainMovementTopic {
    val topic: String = "TRAIN_MVT_FREIGHT"
  }

  object ChangeOfIdentityMessagesForFreightTrains extends TrainMovementTopic {
    val topic: String = "TRAIN_MVT_GENERAL"
  }

  def from(operatingCompany: TrainOperatingCompany): TrainMovementTopic = new TrainMovementTopic {
    override val topic: String = s"TRAIN_MVT_${operatingCompany.businessCode}_TOC"
  }
}