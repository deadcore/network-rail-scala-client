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

package io.igu.networkrail.ws

import java.io.InputStream

import io.reactivex.Observable
import org.json4s.JValue

trait WsRequest {
  def executeAsJValue: Observable[WsResponse[JValue]]

  def executeNoHup: Observable[WsResponse[Unit]]

  def authenticated: WsRequest

  def params(tuple: (String, String)*): WsRequest

  def execute[T](parser: InputStream => T): WsResponse[T]

}
