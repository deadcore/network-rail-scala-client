package io.igu.networkrail.cif

import java.io._

import io.igu.networkrail.model.schedule.ScheduleRecord

import scala.collection.JavaConverters.asScalaIteratorConverter

class CifReader(is: InputStream) {
  private val reader = new BufferedReader(new InputStreamReader(is))

  def stream: Iterator[ScheduleRecord] = reader.lines().iterator().asScala.map(new CifRecord(_)).map(_.asScheduleRecord)
}