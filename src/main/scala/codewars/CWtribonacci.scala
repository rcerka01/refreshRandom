package codewars

import org.scalatest.funsuite.AnyFunSuite

import scala.annotation.tailrec

object CWtribonacci {

  def tribonacci[T : Numeric](signature: List[T], n: Int): List[T] = {
    @tailrec
    def aux(lastThree: List[T], current: Int, acc: List[T]): List[T] =
      if (n <= 0) Nil
      else if (n <= 3) lastThree.take(n)
      else if (current == 0) acc
      else aux(List(lastThree(1), lastThree(2), lastThree.sum) , current - 1, acc :+ lastThree.sum)
    aux(signature, n-3, signature)
  }

}

class CWtribonacciSpec extends AnyFunSuite {
  import CWtribonacci._
  test("tribonacci result must be") {
    assert(tribonacci(List(1, 1, 1), 10) === List(1, 1, 1, 3, 5, 9, 17, 31, 57, 105))
    assert(tribonacci(List(0, 0, 1), 10) === List(0, 0, 1, 1, 2, 4, 7, 13, 24, 44))
    assert(tribonacci(List(0, 1, 1), 10) === List(0, 1, 1, 2, 4, 7, 13, 24, 44, 81))
    assert(tribonacci(List(1, 0, 0), 10) === List(1, 0, 0, 1, 1, 2, 4, 7, 13, 24))
    assert(tribonacci(List(0, 0, 0), 10) === List(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    assert(tribonacci(List(1, 2, 3), 10) === List(1, 2, 3, 6, 11, 20, 37, 68, 125, 230))
    assert(tribonacci(List(3, 2, 1), 10) === List(3, 2, 1, 6, 9, 16, 31, 56, 103, 190))
  }
}
