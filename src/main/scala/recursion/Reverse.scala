package recursion

import org.scalatest.funsuite.AnyFunSuite
import scala.annotation.tailrec

object Reverse {

  implicit class toStringReverse[T](l: List[T]) {
    def myReverse: List[T] = {
      @tailrec
      def aux(l: List[T], acc: List[T]): List[T] =
        if (l.tail.isEmpty) l.head +: acc
        else aux(l.tail, l.head +: acc)
      aux(l, Nil)
    }
  }

//  def reverse[T](l: List[T]): List[T] = {
//    @tailrec
//    def aux(l: List[T], acc: List[T]): List[T] =
//      if (l.tail.isEmpty) l.head +: acc
//      else aux(l.tail, l.head +: acc)
//    aux(l, Nil)
//  }
}

class ReverseSpec extends AnyFunSuite {
  import Reverse._

  test("is reverse") {
    val toTest = List("a","b","c","d")
    val expected = List("d", "c", "b", "a")
    assert(toTest.myReverse === expected)
  }
}
