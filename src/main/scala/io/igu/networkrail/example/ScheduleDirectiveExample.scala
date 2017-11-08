package io.igu.networkrail.example

import io.igu.networkrail.ScheduleDirective
import io.igu.networkrail.ws.scalaj.HttpWsClientProvider

object ScheduleDirectiveExample extends App {

  val directive: ScheduleDirective = new ScheduleDirective with HttpWsClientProvider {
    val username: String = System.getenv("NETWORK_RAIL_USERNAME")
    val password: String = System.getenv("NETWORK_RAIL_PASSWORD")
  }

  directive.schedule.subscribe(x => println(x))

}
