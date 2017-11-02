package io.igu.networkrail.model.schedule

import io.igu.networkrail.cif.model.RecordType

/**
  * Created by jackliddiard on 31/03/17.
  */
case class BasicScheduleExtra(tractionClass: String,
                              uicCode: String,
                              atocCode: String,
                              applicableTimetableCode: String,
                              reservedField: String,
                              reservedField2: String,
                              spare: String) extends ScheduleRecord(RecordType.BASIC_SCHEDULE_EXTRA)
