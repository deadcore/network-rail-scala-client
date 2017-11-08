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

import java.io.InputStream
import java.util.zip.GZIPInputStream

import io.igu.networkrail.ws.WsClientProvider
import io.reactivex.Observable
import org.json4s.JValue
import org.json4s.native.JsonMethods.parse
import org.slf4j.LoggerFactory

import scalaj.http.{HttpRequest, HttpResponse}

trait SupportingFileAuthenticateDirective {
  self: WsClientProvider =>

  private val logger = LoggerFactory.getLogger(this.getClass)

  val username: String
  val password: String

  def supportingFileAuthenticate(source: String): Observable[String] = self.wsClient
    .url("https://datafeeds.networkrail.co.uk/ntrod/SupportingFileAuthenticate")
    .params("type" -> source)
    .authenticated
    .executeNoHup
    .map(_.location.get)


  private implicit class HttpPimps(http: HttpRequest) {
    implicit def asJValue: HttpResponse[JValue] = http.execute(readGzipAsJson)

    implicit def authenticated: HttpRequest = http.auth(username, password)

    implicit def executeNoHup: HttpResponse[Unit] = http.execute(_ => Unit)

    private def readGzipAsJson(is: InputStream): JValue = parse(new GZIPInputStream(is))
  }

}
