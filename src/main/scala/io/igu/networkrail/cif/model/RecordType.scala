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

package io.igu.networkrail.cif.model

import io.igu.networkrail.exception.RecordTypeNotFoundException

object RecordType extends Enumeration {
  type RecordType = Value
  val HEADER,
  TIPLOC_INSERT,
  ASSOCIATION,
  BASIC_SCHEDULE,
  BASIC_SCHEDULE_EXTRA,
  ORIGIN_LOCATION,
  INTERMEDIATE_LOCATION,
  TERMINATING_LOCATION,
  CHANGES_EN_ROUTE,
  TESTING = Value

  def parse(str: String): RecordType = str.toUpperCase match {
    case "HD" => HEADER
    case "TI" => TIPLOC_INSERT
    case "AA" => ASSOCIATION
    case "BS" => BASIC_SCHEDULE
    case "BX" => BASIC_SCHEDULE_EXTRA
    case "LO" => ORIGIN_LOCATION
    case "LI" => INTERMEDIATE_LOCATION
    case "LT" => TERMINATING_LOCATION
    case "CR" => CHANGES_EN_ROUTE
    case "ZZ" => TESTING
    case unknown => throw new RecordTypeNotFoundException(unknown)
  }
}
