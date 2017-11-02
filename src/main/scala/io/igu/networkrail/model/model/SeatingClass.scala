package io.igu.networkrail.model.model

import io.igu.networkrail.exception.SeatingClassNotFoundException

object SeatingClass extends Enumeration {
  type SeatingClass = Value
  val FIRST_AND_STANDARD, STANDARD = Value

  def parse(str: Char): SeatingClass = str match {
    case 'B' => FIRST_AND_STANDARD
    case 'S' => STANDARD
    case ' ' => STANDARD
    case unknown => throw new SeatingClassNotFoundException(unknown)
  }

}