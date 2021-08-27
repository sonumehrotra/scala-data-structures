package com.sonum.ds

import scala.annotation.tailrec

sealed trait List[+T] {
  def isEmpty: Boolean

  def nonEmpty: Boolean = !isEmpty

  def head: T

  def tail: List[T]

  def map[R](f: T => R): List[R]

  def ::[R >: T](elem: R): List[R]

  def reverse: List[T]
}

case object Nil extends List[Nothing] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new Exception("Nil.head")

  override def tail: List[Nothing] = this

  override def map[R](f: Nothing => R): List[R] = this

  override def ::[R >: Nothing](elem: R): List[R] = Cons(elem, Nil)

  override def reverse: List[Nothing] = this
}

case class Cons[+T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false

  override def map[R](f: T => R): List[R] = {

    @tailrec
    def mapOps(remainingList: List[T], newList: List[R]): List[R] = {
      if (remainingList.isEmpty) newList
      else mapOps(remainingList.tail, f(remainingList.head) :: newList)
    }

    mapOps(this, Nil).reverse
  }

  override def ::[R >: T](elem: R): List[R] = Cons(elem, this)

  override def reverse: List[T] = {

    @tailrec
    def reverseOps(reversed: List[T], current: List[T]): List[T] = current match {
      case Nil => reversed
      case Cons(h, tail) => reverseOps(h :: reversed, tail)
    }

    reverseOps(Nil, this)
  }
}
