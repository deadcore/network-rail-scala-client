package io.igu.networkrail

import java.io.InputStream
import java.util.zip.GZIPInputStream

import io.igu.networkrail.ws.WsClientProvider
import io.reactivex.Observable
import org.json4s.JValue
import org.json4s.native.JsonMethods.parse
import org.slf4j.LoggerFactory

import scalaj.http.{HttpRequest, HttpResponse}

trait SupportingFileAuthenticateDirective {
  self: WsClientProvider =>

  private val logger = LoggerFactory.getLogger(this.getClass)

  val username: String
  val password: String

  def supportingFileAuthenticate(source: String): Observable[String] = self.wsClient
    .url("https://datafeeds.networkrail.co.uk/ntrod/SupportingFileAuthenticate")
    .params("type" -> source)
    .authenticated
    .executeNoHup
    .map(_.location.get)


  private implicit class HttpPimps(http: HttpRequest) {
    implicit def asJValue: HttpResponse[JValue] = http.execute(readGzipAsJson)

    implicit def authenticated: HttpRequest = http.auth(username, password)

    implicit def executeNoHup: HttpResponse[Unit] = http.execute(_ => Unit)

    private def readGzipAsJson(is: InputStream): JValue = parse(new GZIPInputStream(is))
  }

}
