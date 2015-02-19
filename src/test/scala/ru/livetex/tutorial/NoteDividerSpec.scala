package ru.livetex.tutorial

import org.scalatest.FlatSpec

class NoteDividerSpec extends FlatSpec {
  info("Note divider should take a sum and a sorted list of notes nominals.")
  info("It should return a list of number for corresponded notes.")

  "Nothing" should "be divided to nothing" in {
    assert(NoteDivider.divide(0, Nil) == Nil)
  }

  "1$" should "be divided to one 1-note" in {
    assert(NoteDivider.divide(1, 1 :: Nil) == 1 :: Nil)
  }

  "2$" should "be divided to two 1-notes" in {
    assert(NoteDivider.divide(2, 1 :: Nil) == 2 :: Nil)
  }

  "3$" should "be divided to 1 1-note and 1 2-note" in {
    assert(NoteDivider.divide(3, 2 :: 1 :: Nil) == 1 :: 1 :: Nil)
  }

  "13$ " should "be divided to 1 10-note, 1 2-note and 1 1-note" in {
    assert(NoteDivider.divide(13, 10 :: 5 :: 2 :: 1 :: Nil) == 1 :: 0 :: 1 :: 1 :: Nil)
  }

  "Any value" should "not be divided if there`s no notes" in {
    assert(NoteDivider.divide(234, Nil) == Nil)
  }
}
