package io.igu.networkrail

import io.igu.networkrail.model.{Corpus, CorpusDeserializer}
import io.igu.networkrail.ws.{WsClientProvider, WsResponse}
import io.reactivex.Observable
import org.json4s.{DefaultFormats, Formats, JValue}

trait CorpusDirective extends SupportingFileAuthenticateDirective {
  self: WsClientProvider =>

  private implicit val formats: Formats = DefaultFormats + CorpusDeserializer

  def corpus: Observable[Seq[Corpus]] = corpusDownloadLink
    .flatMap(url => wsClient.url(url).executeAsJValue)
    .map((wsReponse: WsResponse[JValue]) => (wsReponse.body \ "TIPLOCDATA").extract[Seq[Corpus]])

  private def corpusDownloadLink: Observable[String] = supportingFileAuthenticate("CORPUS")

}
