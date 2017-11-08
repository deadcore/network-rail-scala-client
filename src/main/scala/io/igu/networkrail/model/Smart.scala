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