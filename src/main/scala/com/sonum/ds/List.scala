package com.sonum.ds

sealed trait List[+T] {
  def isEmpty: Boolean

  def nonEmpty: Boolean = !isEmpty

  def head: T

  def tail: List[T]

  def map[R >: T](f: T => R): List[R]

  def ::[R >: T](elem: R): List[R]
}

case object Nil extends List[Nothing] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new Exception("Nil.head")

  override def tail: List[Nothing] = this

  override def map[R >: Nothing](f: Nothing => R): List[R] = this

  override def ::[R >: Nothing](elem: R): List[R] = Cons(elem, Nil)
}

case class Cons[+T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false

  override def map[R >: T](f: T => R): List[R] = {

    def innerRec(remainingList: List[T], newList: List[R]): List[R] = {
      if (remainingList.isEmpty) newList
      else innerRec(remainingList.tail, f(remainingList.head) :: newList)
    }

    innerRec(this, Nil)
  }

  override def ::[R >: T](elem: R): List[R] = Cons(elem, this)

  def ab = scala.collection.immutable.List(1)
}
