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

package io.igu.networkrail

import io.igu.networkrail.model.{Smart, SmartDeserializer}
import io.igu.networkrail.ws.{WsClientProvider, WsResponse}
import io.reactivex.Observable
import org.json4s.{DefaultFormats, JValue}

trait SmartDirective extends SupportingFileAuthenticateDirective {
  self: WsClientProvider =>

  private implicit val formats = DefaultFormats + SmartDeserializer

  def smart: Observable[Seq[Smart]] = smartDownloadLink
    .flatMap(url => wsClient.url(url).executeAsJValue)
    .map((wsReponse: WsResponse[JValue]) => (wsReponse.body \ "BERTHDATA").extract[Seq[Smart]])

  private def smartDownloadLink: Observable[String] = supportingFileAuthenticate("SMART")

}
