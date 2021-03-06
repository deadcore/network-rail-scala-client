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