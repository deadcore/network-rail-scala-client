package io.igu.networkrail.ws

import org.apache.http.HttpResponse


case class HttpWsResponse[T](http: HttpResponse) extends WsResponse[T] {
  override def body: T = http.body

  override def location: Option[String] = http.location
}
