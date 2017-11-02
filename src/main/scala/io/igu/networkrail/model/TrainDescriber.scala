package io.igu.networkrail.model

case class TrainDescriber(caMsg: Seq[BerthStep],
                          cbMsg: Seq[BerthCancel],
                          ccMsg: Seq[BerthInterpose],
                          ctMsg: Seq[Heartbeat],
                          sfMsg: Seq[SignallingUpdate],
                          sgMsg: Seq[SignallingRefresh],
                          shMsg: Seq[SignallingRefreshFinished])