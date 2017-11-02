package io.igu.networkrail.model

import org.json4s.JsonAST.JValue
import org.json4s.{CustomSerializer, DefaultFormats, JObject}


abstract class Deserializer[A: Manifest](ser: JObject => A) extends CustomSerializer[A](_ => ( {
  case json: JObject => ser(json)
}, {
  case _ => throw new UnsupportedOperationException("Operation is not supported to serialise class to json")
}))

object Deserializer {
  private implicit val formats = DefaultFormats

  private def toOptionIfBlank(str: String): Option[String] = if (str.trim.isEmpty) None else Some(str)

  implicit def jvalueToString(jvalue: JValue): String = jvalue.extract[String]
  implicit def jvalueToOptionalString(jvalue: JValue): Option[String] = jvalue.extractOpt[String].flatMap(toOptionIfBlank)

}