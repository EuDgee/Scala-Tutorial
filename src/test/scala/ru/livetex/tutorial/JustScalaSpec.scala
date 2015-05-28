package ru.livetex.tutorial

import org.scalatest.FlatSpec

class JustScalaSpec extends FlatSpec {
  "For" should "iterate over given list" in {
    assert((for (i <- List.range(0, 2)) yield i) == 0 :: 1 :: Nil)
  }

  "For" should "filter out by if predicate" in {
    assert((for (i <- List.range(0, 10) if i % 2 == 0) yield i) == 0 :: 2 :: 4 :: 6 :: 8 :: Nil)
  }

  "For" should "runs until 'until' predicate" in {
    val list = for (i <- 0 until 4) yield i
    assert(list == 0 :: 1 :: 2 :: 3 :: Nil)
  }

  "Var and val" should "define variables" in {
    var a = 0
    val b = 1
    assert(a == 0)
    assert(b == 1)
    a += 1
    assert(a == 1)
    //b += 1
    //assert(b == 2)
  }

  "Case class" should "allow access to its fields" in {
    assert(Data(1, "f").s == "f")
  }

  "Case class" should "work with pattern matching" in {
    Data(1, "f") match {
      case Data(i, _) => assert(i == 1)
      case _ => assert(false)
    }
  }

  "Tuples" should "be cool" in {
    val a = (1, 2)
    //assert(a._1 == 1)
    val (first, _) = a
    assert(first == 1)
  }

  "Collections" should "be awesome" in {
    val reduced = (1 to 4).reduce(_ + _)
    assert(reduced == 10)

    val mapped = (0 to 3).map(_ + 1)
    assert(mapped == (1 to 4))

    val filtered = (0 to 3).filter(_ % 2 == 0)
    assert(filtered == List(0, 2))

    val folded = (1 to 4).foldLeft(1)(_ + _)
    assert(folded == 11)
  }

  "Options" should "ever be used instead of nulls" in {
    val opt = Some(1)
    def func(a: Option[Int]) = a.map(_ + 1)
    assert (func(opt) == Some(2))

    func(opt) match {
      case Some(x) => assert(x == 2)
      case None => assert(false)
    }
  }
}
