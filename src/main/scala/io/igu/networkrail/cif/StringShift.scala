package io.igu.networkrail.cif

class StringShift(str: String, start: Int = 0) {
  private var delta = start

  def char: Char = {
    val idx = delta
    delta += 1
    str.charAt(idx)
  }

  def optChar: Option[Char] = {
    val c = char
    if (Character.isWhitespace(c)) None else Some(c)
  }

  def string(amount: Int): String = readString(amount).trim

  def optString(amount: Int): Option[String] = if (readString(amount).trim.isEmpty) None else Some(readString(amount).trim)

  def integer(amount: Int): Int = string(amount).trim.toInt

  def optInteger(amount: Int): Option[Int] = optString(amount).map(_.toInt)

  private def readString(amount: Int) = {
    val start = delta
    delta += amount
    str.substring(start, delta)
  }
}

//
//class StringShiftNg(str: String, start: Int = 0, shiftAmount: Int = 0) {
//  private val delta = start
//
//  def shift(amount: Int) = new StringShiftNg(str, delta + amount)
//
//  def shift(amount: Int) = new StringShiftNg(str, delta + 1)
//
//  def char: Char = str.charAt(delta)
//
//  def optChar: Option[Char] = {
//    val c = char
//    if (Character.isWhitespace(c)) None else Some(c)
//  }
//
//  def string: String = read.trim
//
//  def optString: Option[String] = Option(StringUtils.defaultIfBlank(read.trim, null))
//
//  def integer: Int = read.trim.toInt
//
//  def optInteger: Option[Int] = optString.map(_.toInt)
//
//  private def read: String = {
//    val start = delta
//    str.substring(start, delta + shiftAmount)
//  }
//}