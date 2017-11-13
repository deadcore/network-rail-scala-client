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

package io.igu.networkrail
import io.reactivex.Observable
import io.reactivex.subjects.ReplaySubject
import org.mockito.Matchers.anyString
import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar

trait TestNetworkRailProvider extends NetworkRailProvider with MockitoSugar {

  val networkRail: NetworkRail = mock[NetworkRail]
  val message$: ReplaySubject[String] = ReplaySubject.create[String]()

  def provide: Observable[NetworkRail] = Observable.just(networkRail)

  def reset(): Unit = {
    when(networkRail.subscribe(anyString())).thenReturn(message$)
  }

}
