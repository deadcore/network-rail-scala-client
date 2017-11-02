package io.igu.networkrail.model

sealed trait TrainOperatingCompany {
  val businessCode: String
  val sectorCode: Option[String]
  val ATOCCode: String
}

object TrainOperatingCompany {

  object AbellioGreaterAnglia extends TrainOperatingCompany {
    val businessCode = "EB"
    val sectorCode = Some("21")
    val ATOCCode = "LE"
  }

  object ArrivaTrainsWales extends TrainOperatingCompany {
    val businessCode = "HL"
    val sectorCode = Some("71")
    val ATOCCode = "AW"
  }

  object c2c extends TrainOperatingCompany {
    val businessCode = "HT"
    val sectorCode = Some("79")
    val ATOCCode = "CC"
  }

  object CaledonianSleeper extends TrainOperatingCompany {
    val businessCode = "ES"
    val sectorCode = Some("35")
    val ATOCCode = "CS"
  }

  object ChilternRailway extends TrainOperatingCompany {
    val businessCode = "HO"
    val sectorCode = Some("74")
    val ATOCCode = "CH"
  }

  object CrossCountry extends TrainOperatingCompany {
    val businessCode = "EH"
    val sectorCode = Some("27")
    val ATOCCode = "XC"
  }

  object DevonAndCornwallRailways extends TrainOperatingCompany {
    val businessCode = "PO"
    val sectorCode = Some("34")
    val ATOCCode = "ZZ"
  }

  object EastMidlandsTrains extends TrainOperatingCompany {
    val businessCode = "EM"
    val sectorCode = Some("28")
    val ATOCCode = "EM"
  }

  object EastCoast extends TrainOperatingCompany {
    val businessCode = "HB"
    val sectorCode = Some("61")
    val ATOCCode = "GR"
  }

  object Eurostar extends TrainOperatingCompany {
    val businessCode = "GA"
    val sectorCode = Some("06")
    val ATOCCode = "ES"
  }

  object FirstCapitalConnect extends TrainOperatingCompany {
    val businessCode = "EG"
    val sectorCode = Some("26")
    val ATOCCode = "FC"
  }

  object FirstGreatWestern extends TrainOperatingCompany {
    val businessCode = "EF"
    val sectorCode = Some("25")
    val ATOCCode = "GW"
  }

  object FirstHullTrains extends TrainOperatingCompany {
    val businessCode = "PF"
    val sectorCode = Some("55")
    val ATOCCode = "HT"
  }

  object FirstScotrail extends TrainOperatingCompany {
    val businessCode = "HA"
    val sectorCode = Some("60")
    val ATOCCode = "SR"
  }

  object TranspennineExpress extends TrainOperatingCompany {
    val businessCode = "EA"
    val sectorCode = Some("20")
    val ATOCCode = "TP"
  }

  object GatwickExpress extends TrainOperatingCompany {
    val businessCode = "HV"
    val sectorCode = Some("81")
    val ATOCCode = "GX"
  }

  object GBRailFreight extends TrainOperatingCompany {
    val businessCode = "PE"
    val sectorCode = Some("54")
    val ATOCCode = "ZZ"
  }

  object GrandCentral extends TrainOperatingCompany {
    val businessCode = "EC"
    val sectorCode = Some("22")
    val ATOCCode = "GC"
  }

  object GreatNorthWesternRailway extends TrainOperatingCompany {
    val businessCode = "LN"
    val sectorCode = None
    val ATOCCode = "LN"
  }

  object GoviaThameslinkRailwayGreatNorthern extends TrainOperatingCompany {
    val businessCode = "ET"
    val sectorCode = Some("88")
    val ATOCCode = "GN"
  }

  object GoviaThameslinkRailwayThameslink extends TrainOperatingCompany {
    val businessCode = "ET"
    val sectorCode = Some("88")
    val ATOCCode = "TL"
  }

  object HeathrowConnect extends TrainOperatingCompany {
    val businessCode = "EE"
    val sectorCode = Some("24")
    val ATOCCode = "HC"
  }

  object HeathrowExpress extends TrainOperatingCompany {
    val businessCode = "HM"
    val sectorCode = Some("86")
    val ATOCCode = "HX"
  }

  object IslandLines extends TrainOperatingCompany {
    val businessCode = "HZ"
    val sectorCode = Some("85")
    val ATOCCode = "IL"
  }

  object LondonMidland extends TrainOperatingCompany {
    val businessCode = "EJ"
    val sectorCode = Some("29")
    val ATOCCode = "LM"
  }

  object LondonOverground extends TrainOperatingCompany {
    val businessCode = "EK"
    val sectorCode = Some("30")
    val ATOCCode = "LO"
  }

  object LULBakerlooLine extends TrainOperatingCompany {
    val businessCode = "XC"
    val sectorCode = Some("91")
    val ATOCCode = "LT"
  }

  object LULDistrictLineWimbledon extends TrainOperatingCompany {
    val businessCode = "XB"
    val sectorCode = Some("90")
    val ATOCCode = "LT"
  }

  object LULDistrictLineRichmond extends TrainOperatingCompany {
    val businessCode = "XE"
    val sectorCode = Some("93")
    val ATOCCode = "LT"
  }

  object Merseyrail extends TrainOperatingCompany {
    val businessCode = "HE"
    val sectorCode = Some("64")
    val ATOCCode = "ME"
  }

  object NetworkRailOnTrackMachines extends TrainOperatingCompany {
    val businessCode = "LR"
    val sectorCode = Some("00*")
    val ATOCCode = "LR"
  }

  object NexusTyneAndWearMetro extends TrainOperatingCompany {
    val businessCode = "PG"
    val sectorCode = Some("56")
    val ATOCCode = "TW"
  }

  object NorthYorkshireMoorsRailway extends TrainOperatingCompany {
    val businessCode = "PR"
    val sectorCode = Some("51")
    val ATOCCode = "NY"
  }

  object NorthernRail extends TrainOperatingCompany {
    val businessCode = "ED"
    val sectorCode = Some("23")
    val ATOCCode = "NT"
  }

  object SouthWestTrains extends TrainOperatingCompany {
    val businessCode = "HY"
    val sectorCode = Some("84")
    val ATOCCode = "SW"
  }

  object Southeastern extends TrainOperatingCompany {
    val businessCode = "HU"
    val sectorCode = Some("80")
    val ATOCCode = "SE"
  }

  object Southern extends TrainOperatingCompany {
    val businessCode = "HW"
    val sectorCode = Some("82")
    val ATOCCode = "SN"
  }

  object SouthYorkshireSupertram extends TrainOperatingCompany {
    val businessCode = "SJ"
    val sectorCode = None
    val ATOCCode = "SJ"
  }

  object SwanageRailway extends TrainOperatingCompany {
    val businessCode = "SP"
    val sectorCode = None
    val ATOCCode = "SP"
  }

  object TfLRail extends TrainOperatingCompany {
    val businessCode = "EX"
    val sectorCode = Some("33")
    val ATOCCode = "XR"
  }

  object VirginTrains extends TrainOperatingCompany {
    val businessCode = "HF"
    val sectorCode = Some("65")
    val ATOCCode = "VT"
  }

  object WestCoastRailwayCompany extends TrainOperatingCompany {
    val businessCode = "PA"
    val sectorCode = Some("50")
    val ATOCCode = "WR"
  }

}