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

import java.time.{DayOfWeek, LocalDate, LocalTime}

import io.igu.networkrail.model.model.{SeatingClass, Status, TrainCategory, TransactionType}
import io.igu.networkrail.model.schedule.{BasicSchedule, Header, TiplocInsert}
import org.scalatest.{MustMatchers, OptionValues, WordSpec}

class CifRecordSpec extends WordSpec with MustMatchers with OptionValues {

  private val headerRecordFixture = "HDTPS.UDFROC1.PD1703010103171944DFROC1PDFROC1OUA010317010318                    "
  private val tiplocInsertFixture = "TIBLTNODR24853600DBOLTON-UPON-DEARNE        24011   0BTDBOLTON ON DEARNE        "
  private val basicScheduleFixture = "BSRC264251612111712030000001 POO2A27    112263310 DMUS   075      S            P"

  "CifRecord" should {
    "asHeader()" should {
      "read a header record correctly" in {
        val record = new CifRecord(headerRecordFixture)

        record.asHeader must equal(Header(
          fileMainframeIdentity = "TPS.UDFROC1.PD170301",
          dateOfExtract = LocalDate.of(2017, 3, 1),
          timeOfExtract = LocalTime.of(19, 44),
          currentFileReference = "DFROC1P",
          lastFileReference = "DFROC1O",
          updateIndicator = "U",
          version = "A",
          userStartDate = LocalDate.of(2017, 3, 1),
          userEndDate = LocalDate.of(2018, 3, 1),
          spare = Some("")
        ))
      }
    }

    "asTiplocInsert()" should {
      "read a header record correctly" in {
        val record = new CifRecord(tiplocInsertFixture)

        record.asTiplocInsert must equal(TiplocInsert(
          tiploc = "BLTNODR",
          capitalsIdentification = 24,
          nlc = 853600,
          nlcCheckChar = 'D',
          tpsDescription = "BOLTON-UPON-DEARNE",
          stanox = 24011,
          poMcpCode = "0",
          crsCode = "BTD",
          nlcDescripition = "BOLTON ON DEARNE",
          spare = ""
        ))
      }
    }


    "asBasicSchedule()" should {
      "read a header record correctly" in {
        val record = new CifRecord(basicScheduleFixture)

        record.asBasicSchedule must equal(BasicSchedule(
          transactionType = TransactionType.REVISE,
          trainUID = "C26425",
          dateRunsFrom = LocalDate.of(2016, 12, 11),
          dateRunsTo = Some(LocalDate.of(2017, 12, 3)),
          daysRunBit = Seq(DayOfWeek.SUNDAY),
          bankHolidayRunning = None,
          trainStatus = Some(Status.PASSENGER_AND_PARCELS_PERMANENT_WTT),
          trainCategory = Some(TrainCategory.ORDINARY_PASSENGER),
          trainIdentity = Some("2A27"),
          headcode = None,
          courseIndicator = 49,
          trainServiceCode = Some(12263310),
          portionId = None,
          powerType = "DMU",
          timingLoad = "S",
          speed = Some(75),
          operatingCharacteristics = None,
          seatingClass = SeatingClass.STANDARD,
          sleepers = None,
          reservations = None,
          connectionIndicator = None,
          cateringCode = Seq.empty,
          serviceBranding = None,
          spare = None,
          stpIndicator = 'P'))
      }
    }

  }

}
