package io.igu.networkrail

import java.time.DayOfWeek

import io.igu.networkrail.model.schedule.ScheduleRecord
import io.reactivex.Observable

trait ScheduleDirective {

  //  def schedule: Observable[ScheduleRecord] = cifDownload("CIF_ALL_FULL_DAILY", "toc-full.CIF.gz")
  //
  //  def schedule(dayOfWeek: DayOfWeek): Observable[ScheduleRecord] = cifDownload("CIF_ALL_UPDATE_DAILY", s"toc-update-${dayOfWeek.asCifFormat}.CIF.gz")

  def schedule: Observable[ScheduleRecord]

  def schedule(dayOfWeek: DayOfWeek): Observable[ScheduleRecord]


  private implicit class DayOfWeekPimps(dow: DayOfWeek) {
    implicit def asCifFormat: String = dow match {
      case DayOfWeek.MONDAY    => "mon"
      case DayOfWeek.TUESDAY   => "tue"
      case DayOfWeek.WEDNESDAY => "wed"
      case DayOfWeek.THURSDAY  => "thu"
      case DayOfWeek.FRIDAY    => "fri"
      case DayOfWeek.SATURDAY  => "sat"
      case DayOfWeek.SUNDAY    => "sun"
    }
  }

}
