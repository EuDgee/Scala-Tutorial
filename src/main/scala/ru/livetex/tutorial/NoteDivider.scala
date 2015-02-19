package ru.livetex.tutorial

object NoteDivider {
  def divide(sum: Int, notes: List[Int]): List[Int] = {
    NoteDivider.accumDivide(Nil, sum, notes).reverse
//    sum match {
//      case 0 => Nil
//      case s => notes match {
//        case x :: xs => (sum / x) :: NoteDivider.divide(sum % x, xs)
//        case Nil => Nil
//      }
//    }
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
