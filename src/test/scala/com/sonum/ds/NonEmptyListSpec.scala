package com.sonum.ds

class NonEmptyListSpec extends ListSpec {

  "A non empty list" should "be able to return head" in {

    nonEmptyInts.head shouldBe 1
  }

  "A non empty list" should "be able to return tail" in {

    nonEmptyInts.tail shouldBe Cons(2, Cons(3, Nil))
  }

  "A non empty list" should "return false when tested for isEmpty op" in {

    nonEmptyInts.isEmpty shouldBe false
  }

  "A non empty list" should "return true when tested for nonEmpty op" in {

    nonEmptyInts.nonEmpty shouldBe true
  }

  "A non empty list" should "evaluate map op" in {

    nonEmptyInts.map(_ * 2) shouldBe Cons(2, Cons(4, Cons(6, Nil)))
  }

  "A non empty list" should "prepend elements using :: op" in {

    4 :: nonEmptyInts shouldBe Cons(4, Cons(1, Cons(2, Cons(3, Nil))))
  }

  "A non empty list" should "should return reversed list using reverse op" in {

    nonEmptyInts.reverse shouldBe Cons(3, Cons(2, Cons(1, Nil)))
  }

}
