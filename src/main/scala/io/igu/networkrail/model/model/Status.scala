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
