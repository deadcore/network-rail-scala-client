package io.igu.networkrail.model.model

import io.igu.networkrail.exception.TransactionTypeNotFoundException

object TransactionType extends Enumeration {
  type TransactionType = Value
  val NEW, DELETE, REVISE = Value

  def parse(str: Char): TransactionType = str match {
    case 'N' => NEW
    case 'D' => DELETE
    case 'R' => REVISE
    case unknown => throw new TransactionTypeNotFoundException(unknown)
  }
}