package io.igu.networkrail.example

import io.igu.networkrail.TrainDescriberDirective
import io.igu.networkrail.model.TrainDescriberTopic
import io.igu.networkrail.stomp.NetworkRailStompProvider

object TrainDescriberDirectiveExample extends App {

  val directive: TrainDescriberDirective = new TrainDescriberDirective with NetworkRailStompProvider {
    val stompServer: String = "datafeeds.networkrail.co.uk"
    val stompPort: Int = 61618
    val username: String = System.getenv("NETWORK_RAIL_USERNAME")
    val password: String = System.getenv("NETWORK_RAIL_PASSWORD")
  }

  directive.trainDescriber(TrainDescriberTopic.AllSignallingAreas).subscribe(x => println(x))

}
