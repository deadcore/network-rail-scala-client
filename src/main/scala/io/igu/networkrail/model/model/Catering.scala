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