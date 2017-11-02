package io.igu.networkrail.model.schedule

import java.time.{LocalDate, LocalTime}

import io.igu.networkrail.cif.model.RecordType

/**
  * Created by jackliddiard on 31/03/17.
  */
case class Header(fileMainframeIdentity: String,
                  dateOfExtract: LocalDate,
                  timeOfExtract: LocalTime,
                  currentFileReference: String,
                  lastFileReference: String,
                  updateIndicator: String,
                  version: String,
                  userStartDate: LocalDate,
                  userEndDate: LocalDate,
                  spare: Option[String]) extends ScheduleRecord(RecordType.HEADER)