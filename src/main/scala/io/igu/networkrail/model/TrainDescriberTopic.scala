package io.igu.networkrail.model

sealed trait TrainDescriberTopic {
  val topic: String
}

object TrainDescriberTopic {

  object AllSignallingAreas extends TrainDescriberTopic {
    val topic: String = "TD_ALL_SIG_AREA"
  }

  object EastScotland extends TrainDescriberTopic {
    val topic: String = "TD_SE_SIG_AREA"
  }

  object WestScotland extends TrainDescriberTopic {
    val topic: String = "TD_SW_SIG_AREA"
  }

  object NorthEastLondonNorthEastern extends TrainDescriberTopic {
    val topic: String = "TD_LNE_NE_SIG_AREA"
  }

  object MidlandsAndContinental extends TrainDescriberTopic {
    val topic: String = "TD_MC_EM_SIG_AREA"
  }

  object GreatNorthernLondonNorthEastern extends TrainDescriberTopic {
    val topic: String = "TD_LNE_GN_SIG_AREA"
  }

  object LondonNorthWesternLancashireAndCumbria extends TrainDescriberTopic {
    val topic: String = "TD_LNW_LC_SIG_AREA"
  }

  object LondonNorthWesternCentral extends TrainDescriberTopic {
    val topic: String = "TD_LNW_C_SIG_AREA"
  }

  object LondonNorthWesternWestMidlandsCentral extends TrainDescriberTopic {
    val topic: String = "TD_LNW_WMC_SIG_AREA"
  }

  object WestCoastSouth extends TrainDescriberTopic {
    val topic: String = "TD_WCS_SIG_AREA"
  }

  object Anglia extends TrainDescriberTopic {
    val topic: String = "TD_ANG_SIG_AREA"
  }

  object KentAndMidlandsContinental extends TrainDescriberTopic {
    val topic: String = "TD_KENT_MCC_SIG_AREA"
  }

  object Sussex extends TrainDescriberTopic {
    val topic: String = "TD_SUSS_SIG_AREA"
  }

  object Wessex extends TrainDescriberTopic {
    val topic: String = "TD_WESS_SIG_AREA"
  }

  object WesternThamesValley extends TrainDescriberTopic {
    val topic: String = "TD_WTV_SIG_AREA"
  }

  object WesternWestCountry extends TrainDescriberTopic {
    val topic: String = "TD_WWC_SIG_AREA"
  }

  object WesternWalesAndMarches extends TrainDescriberTopic {
    val topic: String = "TD_WWM_SIG_AREA"
  }

}