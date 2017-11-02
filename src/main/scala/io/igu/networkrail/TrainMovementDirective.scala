package io.igu.networkrail

import io.igu.networkrail.model._
import io.reactivex.Observable
import org.json4s.native.JsonMethods.parse
import org.json4s.{DefaultFormats, Formats}

import scala.collection.immutable.Stream.Empty

trait TrainMovementDirective {
  self: NetworkRailProvider =>

  private implicit val formats: Formats = DefaultFormats

  def trainMovements(topic: TrainMovementTopic): Observable[Seq[Movement]] = self.provide
    .flatMap(x => x.subscribe(topic.topic))
    .map { (body: String) =>
      val json = parse(body) \ "body"
      json.extract[Seq[Movement]]
    }
}
