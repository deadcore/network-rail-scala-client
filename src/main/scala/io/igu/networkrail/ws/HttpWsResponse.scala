package io.igu.networkrail.ws

import scalaj.http.HttpResponse

case class HttpWsResponse[T](http: HttpResponse[T]) extends WsResponse[T] {
  override def body: T = http.body

  override def location: Option[String] = http.location
}
