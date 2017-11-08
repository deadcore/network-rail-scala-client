package io.igu.networkrail.example

import io.igu.networkrail.SmartDirective
import io.igu.networkrail.ws.scalaj.HttpWsClientProvider

object SmartDirectiveExample extends App {

  val directive: SmartDirective = new SmartDirective with HttpWsClientProvider {
    val stompServer: String = "datafeeds.networkrail.co.uk"
    val stompPort: Int = 61618
    val username: String = System.getenv("NETWORK_RAIL_USERNAME")
    val password: String = System.getenv("NETWORK_RAIL_PASSWORD")
  }

  directive.smart.subscribe(x => println(x))

}
