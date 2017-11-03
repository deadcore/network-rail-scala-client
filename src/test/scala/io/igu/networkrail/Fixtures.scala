package io.igu.networkrail

import scala.io.{BufferedSource, Source}

/**
  * Created by jackliddiard on 08/03/17.
  */
object Fixtures {
  def load(resourcePath: String): BufferedSource = Source.fromURL(getClass.getResource(resourcePath))

  object NetworkRail {
    object Schedule {
      def updateDaily: BufferedSource = load("/fixtures/schedule/cif_all_update_daily-toc-update-wed.cif.gz")
    }

    object Messages {
      def trainDescriber: String = load("/fixtures/messages/train-describer.json").mkString
    }
  }

}
