package io.igu.networkrail.ws

import scalaj.http.Http

trait HttpWsClientProvider extends WsClientProvider {

  val username: String
  val password: String

  override def wsClient: WsClient = (source: String) => HttpWsRequest(Http(source), username, password)
}
