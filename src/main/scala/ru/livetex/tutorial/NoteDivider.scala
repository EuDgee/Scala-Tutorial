package ru.livetex.tutorial

object NoteDivider {
  def divide(sum: Int, notes: List[Int]): List[Int] = {
    NoteDivider.accumDivide(Nil, sum, notes).reverse
  }

  def accumDivide(accum: List[Int], sum: Int, notes: List[Int]): List[Int] = {
    sum match {
      case 0 => accum
      case _ => notes match {
        case x :: xs => NoteDivider.accumDivide(sum / x :: accum, sum % x, xs)
        case Nil => accum
      }
    }
  }
}
