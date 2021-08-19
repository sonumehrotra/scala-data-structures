package com.sonum.ds

sealed trait List[+T] {
  def isEmpty: Boolean

  def nonEmpty: Boolean = !isEmpty

  def head: T

  def tail: List[T]
}

case object Nil extends List[Nothing] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new Exception("Nil.head")

  override def tail: List[Nothing] = this
}

case class Cons[+T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}
