package com.sonum.ds

class EmptyListSpec extends ListSpec {

  "An empty list" should "return an empty tail" in {

    emptyInts.tail shouldBe Nil
  }

  "An empty list" should "return exception when head is accessed" in {

    the [Exception] thrownBy(emptyInts.head) should have message "Nil.head"
  }

  "An empty list" should "return true when tested for isEmpty op" in {

    emptyInts.isEmpty shouldBe true
  }

  "An empty list" should "return false when tested for nonEmpty op" in {

    emptyInts.nonEmpty shouldBe false
  }

}
