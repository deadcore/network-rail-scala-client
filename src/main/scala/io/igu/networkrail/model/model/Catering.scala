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

package io.igu.networkrail.model.model

import io.igu.networkrail.exception.CateringNotFoundException

object Catering extends Enumeration {
  type Catering = Value
  val BUFFET_SERVICE,
  RESTAURANT_CAR_FOR_FIRST_CLASS_PASSENGERS,
  SERVICE_OF_HOT_FOOD_AVAILABLE,
  MEAL_INCLUDE_FOR_FIRST_CLASS_PASSENGERS,
  RESTAURANT,
  TROLLEY_SERVICE = Value

  def parse(str: Char): Catering = str match {
    case 'C' => BUFFET_SERVICE
    case 'F' => RESTAURANT_CAR_FOR_FIRST_CLASS_PASSENGERS
    case 'H' => SERVICE_OF_HOT_FOOD_AVAILABLE
    case 'M' => MEAL_INCLUDE_FOR_FIRST_CLASS_PASSENGERS
    case 'R' => RESTAURANT
    case 'T' => TROLLEY_SERVICE
    case unknown => throw new CateringNotFoundException(unknown)
  }

  def parse(str: String): Seq[Catering] = str.map(parse)
}