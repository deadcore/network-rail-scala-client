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

package io.igu.networkrail

import java.time.DayOfWeek
import java.util.zip.GZIPInputStream

import io.igu.networkrail.cif.CifReader
import io.igu.networkrail.model.schedule.ScheduleRecord
import io.igu.networkrail.ws.WsClientProvider
import io.reactivex.Observable
import org.slf4j.LoggerFactory

trait ScheduleDirective extends CifFileAuthenticateDirective {
  self: WsClientProvider =>

  private val logger = LoggerFactory.getLogger(this.getClass)

  def schedule: Observable[ScheduleRecord] = cifDownload("CIF_ALL_FULL_DAILY", "toc-full.CIF.gz")

  def schedule(dayOfWeek: DayOfWeek): Observable[ScheduleRecord] = cifDownload("CIF_ALL_UPDATE_DAILY", s"toc-update-${dayOfWeek.asCifFormat}.CIF.gz")

  private def cifDownload[T](fileType: String, day: String): Observable[ScheduleRecord] = {
    logger.info(s"Downloading cif file with filetype: [$fileType] and day: [$day]")

    cifFileAuthenticate(fileType, day)
      .flatMap(file => streamFile(file))
  }

  private def streamFile(fileSource: String): Observable[ScheduleRecord] = Observable.create { observer =>
    wsClient.url(fileSource).execute(is => {
      CifReader(new GZIPInputStream(is)).stream.foreach { line =>
        observer.onNext(line)
      }
    })
  }

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
