package io.igu.networkrail

import io.igu.networkrail.model.{Smart, SmartDeserializer}
import io.igu.networkrail.ws.{WsClientProvider, WsResponse}
import io.reactivex.Observable
import org.json4s.{DefaultFormats, JValue}

trait SmartDirective extends SupportingFileAuthenticateDirective {
  self: WsClientProvider =>

  private implicit val formats = DefaultFormats + SmartDeserializer

  def smart: Observable[Seq[Smart]] = smartDownloadLink
    .flatMap(url => wsClient.url(url).executeAsJValue)
    .map((wsReponse: WsResponse[JValue]) => (wsReponse.body \ "BERTHDATA").extract[Seq[Smart]])

  private def smartDownloadLink: Observable[String] = supportingFileAuthenticate("SMART")

}
