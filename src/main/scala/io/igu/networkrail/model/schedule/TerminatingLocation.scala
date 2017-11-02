package io.igu.networkrail.model.schedule

import java.time.LocalTime

import io.igu.networkrail.cif.model.RecordType

case class TerminatingLocation(location: String,
                               scheduledArrival: Option[LocalTime],
                               publicArrival: LocalTime,
                               platform: String,
                               path: Option[String],
                               activity: String,
                               reservedField: Option[String],
                               spare: Option[String]) extends ScheduleRecord(RecordType.TERMINATING_LOCATION)
