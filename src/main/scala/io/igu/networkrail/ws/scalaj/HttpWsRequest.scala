package io.igu.networkrail.ws.scalaj

import java.io.InputStream
import java.util.zip.GZIPInputStream

import io.igu.networkrail.ws.{WsRequest, WsResponse}
import io.reactivex.Observable
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods.parse

import scalaj.http.HttpRequest

case class HttpWsRequest(http: HttpRequest, username: String, password: String) extends WsRequest {
  override def executeAsJValue: Observable[WsResponse[JValue]] = Observable.defer(() => {
    Observable.just(
      HttpWsResponse(http.execute(readGzipAsJson))
    )
  })


  private def readGzipAsJson(is: InputStream): JValue = parse(new GZIPInputStream(is))

  override def executeNoHup: Observable[WsResponse[Unit]] = Observable.defer(() => {
    Observable.just(
      HttpWsResponse(http.execute(_ => {
        Unit
      }))
    )
  })

  override def authenticated: WsRequest = copy(http = http.auth(username, password))

  override def params(tuple: (String, String)*): HttpWsRequest = copy(http = http.params(tuple))

  override def execute[T](parser: InputStream => T): WsResponse[T] = HttpWsResponse(http.execute(parser))
}
