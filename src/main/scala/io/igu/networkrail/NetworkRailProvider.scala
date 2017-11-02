package io.igu.networkrail

import io.reactivex.Observable

trait NetworkRailProvider {

  def provide: Observable[NetworkRail]

}
