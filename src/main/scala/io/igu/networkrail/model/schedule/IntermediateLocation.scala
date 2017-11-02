package io.igu.networkrail.model.schedule

import java.time.LocalTime

import io.igu.networkrail.cif.model.RecordType

case class IntermediateLocation(location: String,
                                scheduledArrival: Option[LocalTime],
                                scheduledDeparture: Option[LocalTime],
                                scheduledPass: Option[LocalTime],
                                publicArrival: Option[LocalTime],
                                publicDeparture: Option[LocalTime],
                                platform: Option[String],
                                line: Option[String],
                                path: Option[String],
                                activity: Option[String],
                                engineeringAllowance: Option[String],
                                pathingAllowance: Option[String],
                                performanceAllowance: Option[String],
                                reservedField: Option[String],
                                spare: Option[String]) extends ScheduleRecord(RecordType.INTERMEDIATE_LOCATION)