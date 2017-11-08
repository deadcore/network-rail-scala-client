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

package io.igu.networkrail.cif

import java.time.format.DateTimeFormatter
import java.time.{DayOfWeek, LocalDate, LocalTime}

import io.igu.networkrail.cif.CifRecord.{dayMonthYearFormat, yearMonthDayFormat}
import io.igu.networkrail.cif.model.RecordType
import io.igu.networkrail.cif.model.RecordType.RecordType
import io.igu.networkrail.model.model._
import io.igu.networkrail.model.schedule.{Association => _, _}

class CifRecord(record: String) {
  def recordType: RecordType = RecordType.parse(record.substring(0, 2))

  def asScheduleRecord: ScheduleRecord = recordType match {
    case RecordType.HEADER => asHeader
    case RecordType.BASIC_SCHEDULE => asBasicSchedule
    case RecordType.BASIC_SCHEDULE_EXTRA => asBasicScheduleExtra
    case RecordType.INTERMEDIATE_LOCATION => asIntermediateLocation
    case RecordType.TERMINATING_LOCATION => asTerminatingLocation
    case unknown: RecordType => new ScheduleRecord(unknown) {}
  }

  def asTiplocInsert: TiplocInsert = withStringShift(record => TiplocInsert(
    tiploc = record.string(7),
    capitalsIdentification = record.integer(2),
    nlc = record.integer(6),
    nlcCheckChar = record.char,
    tpsDescription = record.string(26),
    stanox = record.integer(5),
    poMcpCode = record.string(4),
    crsCode = record.string(3),
    nlcDescripition = record.string(16),
    spare = record.string(8)
  ))

  def asTerminatingLocation: TerminatingLocation = withStringShift(record => TerminatingLocation(
    record.string(8),
    record.optString(5).map(x => new StringShift(x)).map(str => LocalTime.parse(str.string(4), DateTimeFormatter.ofPattern("HHmm"))),
    LocalTime.parse(record.string(4), DateTimeFormatter.ofPattern("HHmm")),
    record.string(3),
    record.optString(3),
    record.string(12),
    record.optString(3),
    record.optString(40)
  ))

  def asBasicScheduleExtra: BasicScheduleExtra = withStringShift { record =>
    BasicScheduleExtra(
      tractionClass = record.string(4),
      uicCode = record.string(5),
      atocCode = record.string(2),
      applicableTimetableCode = record.string(1),
      reservedField = record.string(8),
      reservedField2 = record.string(1),
      spare = record.string(57)
    )
  }

  def asBasicSchedule: BasicSchedule = withStringShift { record =>
    BasicSchedule(
      transactionType = TransactionType.parse(record.char),
      trainUID = record.string(6),
      dateRunsFrom = LocalDate.parse(record.string(6), yearMonthDayFormat),
      dateRunsTo = record.optString(6).filter(x => x == "00000000").map(LocalDate.parse(_, yearMonthDayFormat)),
      daysRunBit = asDayOfWeeks(record.string(7)),
      bankHolidayRunning = record.optChar,
      trainStatus = record.optChar.map(Status.parse),
      trainCategory = record.optString(2).map(TrainCategory.parse),
      trainIdentity = record.optString(4),
      headcode = record.optString(4),
      courseIndicator = record.char.toInt,
      trainServiceCode = record.optInteger(8),
      portionId = record.optChar,
      powerType = record.string(3),
      timingLoad = record.string(4),
      speed = record.optInteger(3),
      operatingCharacteristics = record.optString(6),
      seatingClass = SeatingClass.parse(record.char),
      sleepers = record.optChar,
      reservations = record.optChar,
      connectionIndicator = record.optChar,
      cateringCode = record.optString(4).map(Catering.parse).getOrElse(Seq.empty),
      serviceBranding = record.optString(4),
      spare = record.optString(1),
      stpIndicator = record.char
    )
  }

  private def asDayOfWeeks(str: String): Seq[DayOfWeek] = str.toCharArray.zipWithIndex.filter(x => x._1 == '1').map(x => DayOfWeek.of(x._2 + 1))

  def asHeader: Header = withStringShift { shift =>
    Header(
      fileMainframeIdentity = shift.string(20),
      dateOfExtract = LocalDate.parse(shift.string(6), dayMonthYearFormat),
      timeOfExtract = LocalTime.of(shift.integer(2), shift.integer(2)),
      currentFileReference = shift.string(7).trim,
      lastFileReference = shift.string(7).trim,
      updateIndicator = shift.string(1).trim,
      version = shift.string(1).trim,
      userStartDate = LocalDate.parse(shift.string(6), dayMonthYearFormat),
      userEndDate = LocalDate.parse(shift.string(6), dayMonthYearFormat),
      spare = shift.optString(20)
    )
  }

  def asOriginLocation: OriginLocation = withStringShift { shift =>
    OriginLocation(
      location = shift.string(8),
      scheduledDeparture = shift.string(5),
      publicDeparture = shift.string(4),
      platform = shift.string(3),
      line = shift.string(3),
      engineeringAllowance = shift.string(2),
      pathingAllowance = shift.string(2),
      activity = shift.string(12),
      performanceAllowance = shift.string(2),
      reservedfield = shift.string(3),
      spare = shift.string(34)
    )
  }

  def asIntermediateLocation: IntermediateLocation = withStringShift( record => IntermediateLocation(
    location = record.string(8),
    scheduledArrival = record.optString(5).map(x => new StringShift(x)).map(str => LocalTime.parse(str.string(4), DateTimeFormatter.ofPattern("HHmm"))),
    scheduledDeparture = record.optString(5).map(x => new StringShift(x)).map(str => LocalTime.parse(str.string(4), DateTimeFormatter.ofPattern("HHmm"))),
    scheduledPass = record.optString(5).map(x => new StringShift(x)).map(str => LocalTime.parse(str.string(4), DateTimeFormatter.ofPattern("HHmm"))),
    publicArrival = record.optString(4).map(x => new StringShift(x)).map(str => LocalTime.parse(str.string(4), DateTimeFormatter.ofPattern("HHmm"))),
    publicDeparture = record.optString(4).map(x => new StringShift(x)).map(str => LocalTime.parse(str.string(4), DateTimeFormatter.ofPattern("HHmm"))),
    platform = record.optString(3),
    line = record.optString(3),
    path = record.optString(3),
    activity = record.optString(12),
    engineeringAllowance = record.optString(2),
    pathingAllowance = record.optString(2),
    performanceAllowance = record.optString(2),
    reservedField = record.optString(5),
    spare = record.optString(15)
  ))

  private def withStringShift[T](block: StringShift => T): T = block(new StringShift(record, 2))
}


object CifRecord {
  private val yearMonthDayFormat = DateTimeFormatter.ofPattern("yyMMdd")
  private val dayMonthYearFormat = DateTimeFormatter.ofPattern("ddMMyy")
}