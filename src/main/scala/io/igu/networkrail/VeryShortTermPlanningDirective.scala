package io.igu.networkrail

import io.reactivex.Observable

trait VeryShortTermPlanningDirective {
  def veryShortTermPlanning: Observable[Nothing]
}
