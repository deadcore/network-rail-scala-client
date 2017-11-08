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

package io.igu.networkrail.model.schedule

import java.time.{DayOfWeek, LocalDate}

import io.igu.networkrail.cif.model.RecordType
import io.igu.networkrail.model.model.Catering.Catering
import io.igu.networkrail.model.model.SeatingClass.SeatingClass
import io.igu.networkrail.model.model.Status.Status
import io.igu.networkrail.model.model.TrainCategory.TrainCategory
import io.igu.networkrail.model.model.TransactionType.TransactionType

/**
  * Created by jackliddiard on 31/03/17.
  */
case class BasicSchedule(transactionType: TransactionType,
                         trainUID: String,
                         dateRunsFrom: LocalDate,
                         dateRunsTo: Option[LocalDate],
                         daysRunBit: Seq[DayOfWeek],
                         bankHolidayRunning: Option[Char],
                         trainStatus: Option[Status],
                         trainCategory: Option[TrainCategory],
                         trainIdentity: Option[String],
                         headcode: Option[String],
                         courseIndicator: Int,
                         trainServiceCode: Option[Int],
                         portionId: Option[Char],
                         powerType: String,
                         timingLoad: String,
                         speed: Option[Int],
                         operatingCharacteristics: Option[String],
                         seatingClass: SeatingClass,
                         sleepers: Option[Char],
                         reservations: Option[Char],
                         connectionIndicator: Option[Char],
                         cateringCode: Seq[Catering],
                         serviceBranding: Option[String],
                         spare: Option[String],
                         stpIndicator: Char) extends ScheduleRecord(RecordType.BASIC_SCHEDULE)
