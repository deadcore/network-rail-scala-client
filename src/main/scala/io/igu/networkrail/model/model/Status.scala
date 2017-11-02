package io.igu.networkrail.model.model

import io.igu.networkrail.exception.StatusNotFoundException

object Status extends Enumeration {
  type Status = Value
  val BUS_PERMANENT,
  FREIGHT_PERMANENT_WTT,
  PASSENGER_AND_PARCELS_PERMANENT_WTT,
  SHIP_PERMANENT,
  TRIP_PERMANENT,
  STP_PASSENGER_AND_PARCELS,
  STP_FREIGHT,
  STP_TRIP,
  STP_SHIP,
  STP_BUS = Value

  def parse(str: Char): Status = str match {
    case 'B' => BUS_PERMANENT
    case 'F' => FREIGHT_PERMANENT_WTT
    case 'P' => PASSENGER_AND_PARCELS_PERMANENT_WTT
    case 'S' => SHIP_PERMANENT
    case 'T' => TRIP_PERMANENT
    case '1' => STP_PASSENGER_AND_PARCELS
    case '2' => STP_FREIGHT
    case '3' => STP_TRIP
    case '4' => STP_SHIP
    case '5' => STP_BUS
    case unknown => throw new StatusNotFoundException(unknown)
  }
}
