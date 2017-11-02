package io.igu.networkrail.ws

trait WsResponse[T] {

  def body: T

  def location: Option[String]
}
