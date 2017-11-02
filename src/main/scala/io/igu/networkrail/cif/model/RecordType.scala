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
