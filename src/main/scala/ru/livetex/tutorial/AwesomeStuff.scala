package ru.livetex.tutorial

object AwesomeStuff {
  implicit class IntWithTimes(x: Int) {
    def times[T](f: => T): Unit = {
      for (i <- 1 to x) f
    }
  }
}
