package hundredScalaProblems

import org.scalatest.funsuite.AnyFunSuite

import scala.annotation.tailrec

//P39 (*) A list of prime numbers.
//Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
//scala> listPrimesinRange(7 to 31)
//res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

import P31._

object P39 {

  def listPrimesinRange(start: Int, end: Int): List[Int] = {
// 1.
//     ((for (x <- start to end) yield if (x.isPrime()) x else 0) filter(r => r != 0)).toList

// 2.
//    @tailrec
//    def aux(current: Int, acc: List[Int]): List[Int] =
//      if (current < start) acc
//      else aux(current - 1, if (current.isPrime()) acc :+ current else acc)
//    aux(end, Nil).reverse
    @tailrec
    def aux(current: Int, acc: List[Int]): List[Int] =
      if (current > end) acc
      else aux(current + 1, if (current.isPrime()) acc :+ current else acc)
    aux(start, Nil)
  }
}

class P39Test extends AnyFunSuite {
  import P39._
  test ("is List(7, 11, 13, 17, 19, 23, 29, 31) correct for listPrimesinRange(7 to 31)") {
    val given = listPrimesinRange(7, 31)
    val expected = List(7, 11, 13, 17, 19, 23, 29, 31)
    assert(given === expected)
  }
}
