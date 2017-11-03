package io.igu.networkrail.stomp

import java.util

import com.hi3project.vineyard.comm.stomp.gozirraws.{Client, Listener}
import io.igu.networkrail.{NetworkRail, NetworkRailProvider}
import io.reactivex.Observable
import org.slf4j.LoggerFactory

trait NetworkRailStompProvider extends NetworkRailProvider {

  private val logger = LoggerFactory.getLogger(this.getClass)

  val stompServer: String
  val stompPort: Int
  val username: String
  val password: String

  val client: Observable[Client] = Observable.create { subscriber =>
    val client = new Client(stompServer, stompPort, username, password)

    if (client.isConnected) subscriber.onNext(client)
  }

  def provide: Observable[NetworkRail] = client.map(client => new NetworkRail {
    override def subscribe(topic: String): Observable[String] = Observable.create { observer =>
      client.subscribe(s"/topic/$topic", Listener { (body: String) =>
        logger.trace("Received body: {}", body)

        observer.onNext(body)
      })
    }
  })


  object Listener {
    def apply(block: (util.Map[_, _], String) => Unit): Listener = new Listener {
      override def message(headers: util.Map[_, _], body: String): Unit = block(headers, body)
    }

    def apply(block: String => Unit): Listener = new Listener {
      override def message(headers: util.Map[_, _], body: String): Unit = block(body)
    }
  }

}
