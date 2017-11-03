package io.igu.networkrail

import java.io.InputStream
import java.time.DayOfWeek
import java.util
import java.util.zip.GZIPInputStream

import io.igu.networkrail.cif.CifReader
import io.igu.networkrail.model.schedule.ScheduleRecord
import io.igu.networkrail.ws.WsClientProvider
import io.reactivex.{Emitter, Flowable, Observable}
import io.reactivex.subjects.PublishSubject
import org.slf4j.LoggerFactory

trait ScheduleDirective extends CifFileAuthenticateDirective {
  self: WsClientProvider =>

  private val logger = LoggerFactory.getLogger(this.getClass)

  def schedule: Observable[ScheduleRecord] = cifDownload("CIF_ALL_FULL_DAILY", "toc-full.CIF.gz")

  def schedule(dayOfWeek: DayOfWeek): Observable[ScheduleRecord] = cifDownload("CIF_ALL_UPDATE_DAILY", s"toc-update-${dayOfWeek.asCifFormat}.CIF.gz")

  private def cifDownload[T](fileType: String, day: String): Observable[ScheduleRecord] = {
    logger.info(s"Downloading cif file with filetype: [$fileType] and day: [$day]")

    cifFileAuthenticate(fileType, day)
      .flatMap(file => wsClient.url(file).execute)
      .map(is => from(is, 70))
  }

  private def from(is: InputStream, bufferSize: Int) = Observable.generate((emitter: Emitter[Array[Byte]]) => {
    val buffer = new Array[Byte](bufferSize)
    val count = is.read(buffer)
    if (count == -1) emitter.onComplete()
    else if (count < bufferSize) emitter.onNext(util.Arrays.copyOf(buffer, count))
    else emitter.onNext(buffer)
  })

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
