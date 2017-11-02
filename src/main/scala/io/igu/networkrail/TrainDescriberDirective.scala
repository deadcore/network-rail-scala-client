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
