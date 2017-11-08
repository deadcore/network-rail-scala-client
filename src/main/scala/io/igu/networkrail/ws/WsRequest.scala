package io.igu.networkrail.ws

import java.io.InputStream

import io.reactivex.Observable
import org.json4s.JValue

trait WsRequest {
  def executeAsJValue: Observable[WsResponse[JValue]]

  def executeNoHup: Observable[WsResponse[Unit]]

  def authenticated: WsRequest

  def params(tuple: (String, String)*): WsRequest

  def execute[T](parser: InputStream => T): WsResponse[T]

}
