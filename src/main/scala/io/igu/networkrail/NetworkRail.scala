package io.igu.networkrail

import io.reactivex.Observable

trait NetworkRail {
  def subscribe(topic: String): Observable[String]
}
