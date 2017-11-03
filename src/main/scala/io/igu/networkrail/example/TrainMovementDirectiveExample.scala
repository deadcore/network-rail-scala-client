package io.igu.networkrail.example

import io.igu.networkrail.TrainMovementDirective
import io.igu.networkrail.model.TrainMovementTopic
import io.igu.networkrail.stomp.NetworkRailStompProvider

object TrainMovementDirectiveExample extends App {

  val directive: TrainMovementDirective = new TrainMovementDirective with NetworkRailStompProvider {
    val stompServer: String = "datafeeds.networkrail.co.uk"
    val stompPort: Int = 61618
    val username: String = System.getenv("NETWORK_RAIL_USERNAME")
    val password: String = System.getenv("NETWORK_RAIL_PASSWORD")
  }

  directive.trainMovements(TrainMovementTopic.AllTrainOperatingCompanies).subscribe(x => println(x))

}
