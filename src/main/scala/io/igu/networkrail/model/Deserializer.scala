/*
 * Copyright (c) 2017 igu.io. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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