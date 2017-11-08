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

import io.igu.networkrail.model._
import io.reactivex.Observable
import org.json4s.native.JsonMethods.parse
import org.json4s.{DefaultFormats, Formats}

import scala.collection.immutable.Stream.Empty

trait TrainDescriberDirective {
  self: NetworkRailProvider =>

  private implicit val formats: Formats = DefaultFormats

  def trainDescriber(topic: TrainDescriberTopic): Observable[TrainDescriber] = self.provide
    .flatMap(x => x.subscribe(topic.topic))
    .map { (body: String) =>
      val parsedJson = parse(body)

      val caMsg = (parsedJson \ "CA_MSG").extractOrElse[Seq[BerthStep]](Empty)
      val cbMsg = (parsedJson \ "CB_MSG").extractOrElse[Seq[BerthCancel]](Empty)
      val ccMsg = (parsedJson \ "CC_MSG").extractOrElse[Seq[BerthInterpose]](Empty)
      val ctMsg = (parsedJson \ "CT_MSG").extractOrElse[Seq[Heartbeat]](Empty)

      val sfMsg = (parsedJson \ "SF_MSG").extractOrElse[Seq[SignallingUpdate]](Empty)
      val sgMsg = (parsedJson \ "SG_MSG").extractOrElse[Seq[SignallingRefresh]](Empty)
      val shMsg = (parsedJson \ "SH_MSG").extractOrElse[Seq[SignallingRefreshFinished]](Empty)

      TrainDescriber(
        caMsg,
        cbMsg,
        ccMsg,
        ctMsg,
        sfMsg,
        sgMsg,
        shMsg
      )
    }
}
