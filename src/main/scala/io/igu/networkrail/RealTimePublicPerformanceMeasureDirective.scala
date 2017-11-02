package io.igu.networkrail

import io.reactivex.Observable


trait RealTimePublicPerformanceMeasureDirective {
  self: NetworkRailProvider =>

  def realTimePublicPerformanceMeasure: Observable[String] = self.provide
    .flatMap(_.subscribe("RTPPM_ALL"))
}
