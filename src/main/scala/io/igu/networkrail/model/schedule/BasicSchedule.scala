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
