package io.igu.networkrail.model.schedule

import io.igu.networkrail.cif.model.RecordType

/**
  * Created by jackliddiard on 31/03/17.
  */
case class OriginLocation(location: String,
                          scheduledDeparture: String,
                          publicDeparture: String,
                          platform: String,
                          line: String,
                          engineeringAllowance: String,
                          pathingAllowance: String,
                          activity: String,
                          performanceAllowance: String,
                          reservedfield: String,
                          spare: String) extends ScheduleRecord(RecordType.ORIGIN_LOCATION)
