package ru.livetex.tutorial

class Foo(incrArg: Int) {
  def incr(a: Int) = a + incrArg
}

class Bar(inc: Int) extends Foo(inc) {
  def incrX2: Int => Int = 2 * incr(_)
}

case class Data(i: Int, s: String)
