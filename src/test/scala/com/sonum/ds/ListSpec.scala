package com.sonum.ds

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

trait ListSpec extends AnyFlatSpec with Matchers {

  val nonEmptyInts: List[Int] = Cons(1, Cons(2, Cons(3, Nil)))
  val emptyInts: List[Int] = Nil
}
