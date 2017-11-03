package io.igu.networkrail.ws

import java.io.InputStream

import io.reactivex.Observable
import org.apache.http.auth.{AuthScope, UsernamePasswordCredentials}
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.impl.client.{BasicCredentialsProvider, HttpClientBuilder}
import org.json4s.JsonAST.JValue

case class ApacheClientRequest(request: HttpUriRequest, client: HttpClientBuilder, username: String, password: String) extends WsRequest {

  override def executeAsJValue: Observable[WsResponse[JValue]] = Observable.defer(() => {
    Observable.just(
      HttpWsResponse(client.build().execute(request))
    )
  })

  override def executeNoHup: Observable[WsResponse[Unit]] = Observable.defer(() => {
    Observable.just(
      HttpWsResponse(client.build().execute(request))
    )
  })

  override def execute: Observable[WsResponse[InputStream]] = Observable.defer(() => {
    Observable.just(
      HttpWsResponse(client.build().execute(request))
    )
  })

  override def authenticated: WsRequest = {
    val provider = new BasicCredentialsProvider
    provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password))

    client.setDefaultCredentialsProvider(provider)
    this
  }

  override def params(tuple: (String, String)*) = {
    request.setParams()
  }

}
