package io.igu.networkrail.model

import io.igu.networkrail.model.Deserializer.jvalueToString

case class Smart(trainDescriber: String,
                 fromBerth: String,
                 toBerth: String,
                 fromLine: String,
                 toLine: String,
                 berthOffset: String,
                 platform: String,
                 event: String,
                 route: String,
                 stanox: String,
                 stanme: String,
                 stepType: String,
                 comment: String)


object SmartDeserializer extends Deserializer[Smart](json => Smart(
  trainDescriber = json \ "TD",
  fromBerth = json \ "FROMBERTH",
  toBerth = json \ "TOBERTH",
  fromLine = json \ "FROMLINE",
  toLine = json \ "TOLINE",
  berthOffset = json \ "BERTHOFFSET",
  platform = json \ "PLATFORM",
  event = json \ "EVENT",
  route = json \ "ROUTE",
  stanox = json \ "STANOX",
  stanme = json \ "STANME",
  stepType = json \ "STEPTYPE",
  comment = json \ "COMMENT"
))