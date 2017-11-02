package io.igu.networkrail.model

import io.igu.networkrail.model.Deserializer.{jvalueToOptionalString, jvalueToString}

case class Corpus(locationCode: Option[String],
                  nlc: String,
                  nlcDescription: String,
                  nlcDescription16: Option[String],
                  stanoxCode: Option[String],
                  tiplocCode: Option[String],
                  uicCode: Option[String])

object CorpusDeserializer extends Deserializer[Corpus](json => Corpus(
  json \ "3ALPHA",
  json \ "NLC",
  json \ "NLCDESC",
  json \ "NLCDESC16",
  json \ "STANOX",
  json \ "TIPLOC",
  json \ "UIC"
))