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

import scala.io.{BufferedSource, Source}

/**
  * Created by jackliddiard on 08/03/17.
  */
object Fixtures {
  def load(resourcePath: String): BufferedSource = Source.fromURL(getClass.getResource(resourcePath))

  object NetworkRail {
    object Schedule {
      def updateDaily: BufferedSource = load("/fixtures/schedule/cif_all_update_daily-toc-update-wed.cif.gz")
    }

    object Messages {
      def trainDescriber: String = load("/fixtures/messages/train-describer.json").mkString
    }
  }

}
