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

import io.igu.networkrail.model.{TrainDescriber, TrainDescriberTopic}
import io.reactivex.Observable
import io.reactivex.subjects.ReplaySubject
import org.mockito.Matchers.{any, anyString}
import org.mockito.Mockito.{reset, times, verify, when}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, MustMatchers, OptionValues, WordSpec}

class TrainDescriberDirectiveTest extends WordSpec with MustMatchers with OptionValues with MockitoSugar with BeforeAndAfter {


  private val message$: ReplaySubject[String] = ReplaySubject.create[String]()
  private val networkRailClient: NetworkRail = mock[NetworkRail]

  private val directive: TrainDescriberDirective = new TrainDescriberDirective with TestNetworkRailProvider {
    val networkRail: NetworkRail = networkRailClient
  }

  before {
    reset(networkRailClient)
    when(networkRailClient.subscribe(anyString())).thenReturn(message$)
  }

  "TrainDescriberDirective" should {
    "trainDescriber(Topic)" should {
      val fixture = TrainDescriberTopic.WesternThamesValley

      "parse valid json to a [TrainDescriber]" in {
        val validator = mock[(TrainDescriber => Any)]

        directive.trainDescriber(fixture).subscribe(x => validator(x))

        message$.onNext(Fixtures.NetworkRail.Messages.trainDescriber)

        verify(validator, times(1)).apply(any[TrainDescriber])
      }

    }
  }

}