package io.igu.networkrail
import io.reactivex.Observable

trait TestNetworkRailProvider extends NetworkRailProvider {

  val networkRail: NetworkRail

  override def provide: Observable[NetworkRail] = Observable.just(networkRail)

}
