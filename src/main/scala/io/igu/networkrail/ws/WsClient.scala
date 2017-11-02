package io.igu.networkrail.ws

trait WsClient {
  def url(source: String): WsRequest
}
