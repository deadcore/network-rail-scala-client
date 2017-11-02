package io.igu.networkrail.model.schedule

import io.igu.networkrail.cif.model.RecordType

case class TiplocInsert(tiploc: String,
                        capitalsIdentification: Int,
                        nlc: Int,
                        nlcCheckChar: Char,
                        tpsDescription: String,
                        stanox: Int,
                        poMcpCode: String,
                        crsCode: String,
                        nlcDescripition: String,
                        spare: String) extends ScheduleRecord(RecordType.TIPLOC_INSERT)
