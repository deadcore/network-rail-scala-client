package io.igu.networkrail.ws.scalaj

import io.igu.networkrail.ws.{WsClient, WsClientProvider}

import scalaj.http.Http

trait HttpWsClientProvider extends WsClientProvider {
  val username: String
  val password: String

  def wsClient: WsClient = (source: String) => HttpWsRequest(Http(source), username, password)
}
