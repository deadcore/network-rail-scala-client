/*
 * Copyright (c) 2017 igu.io. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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

  val client: Observable[Client] = Observable.defer(() => {
    Observable.just(new Client(stompServer, stompPort, username, password))
  })

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
