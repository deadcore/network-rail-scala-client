package io.igu.networkrail

import io.igu.networkrail.ws.WsClientProvider
import io.reactivex.Observable

trait CifFileAuthenticateDirective {
  self: WsClientProvider =>

  def cifFileAuthenticate(fileType: String, day: String): Observable[String] = wsClient
    .url("https://datafeeds.networkrail.co.uk/ntrod/CifFileAuthenticate")
    .params("type" -> fileType, "day" -> day)
    .authenticated
    .executeNoHup
    .map(_.location.get)

}