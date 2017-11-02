package io.igu.networkrail

import io.igu.networkrail.model.{TrainDescriber, TrainDescriberTopic}
import io.reactivex.Observable
import io.reactivex.subjects.ReplaySubject
import org.mockito.Matchers.{any, anyString}
import org.mockito.Mockito.{reset, times, verify, when}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, MustMatchers, OptionValues, WordSpec}

class TrainDescriberDirectiveTest extends WordSpec with MustMatchers with OptionValues with MockitoSugar with BeforeAndAfter {


  private val message$: Observable[String] = new ReplaySubject[String]()
  private val networkRail: NetworkRail = mock[NetworkRail]

  private val directive: TrainDescriberDirective = new TrainDescriberDirective with TestNetworkRailProvider {
    override val networkRail = networkRail
  }

  before {
    reset(networkRail)
    when(networkRail.subscribe(anyString())).thenReturn(message$)
  }

  "TrainDescriberDirective" should {
    "trainDescriber(Topic)" should {
      val fixture = TrainDescriberTopic.WesternThamesValley

      "parse valid json to a [TrainDescriber]" in {
        val validator = mock[(TrainDescriber => Any)]

        directive.trainDescriber(fixture).subscribe(x => validator(x))

        directive.message$()

        verify(validator, times(1)).apply(any[TrainDescriber])
      }

    }
  }

}