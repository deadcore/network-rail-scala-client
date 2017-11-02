package io.igu.networkrail.model.schedule

import java.time.LocalDate

import io.igu.networkrail.cif.model.RecordType


case class Association(transactionType: String,
                       mainTrainUID: String,
                       associatedTrainUID: String,
                       associationStart: LocalDate) extends ScheduleRecord(RecordType.ASSOCIATION)








