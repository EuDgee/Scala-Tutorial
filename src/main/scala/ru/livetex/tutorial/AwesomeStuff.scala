package ru.livetex.tutorial

object AwesomeStuff {
  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      for (i <- 1 to x) f
    }
  }
}
