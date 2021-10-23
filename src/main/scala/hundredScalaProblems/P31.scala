package hundredScalaProblems

import org.scalatest.funsuite.AnyFunSuite

import scala.annotation.tailrec

object  P31 {
  implicit class P31Implicit(i: Int) {
    def isPrime(): Boolean = {
      @tailrec
      def aux(acc: Int): Boolean = {
        if (i < 2) false
        else if (acc < 2) true
        else if (i % acc == 0) false
        else aux(acc - 1)
      }
      aux(i-1)
    }
  }
}

class P31Test extends AnyFunSuite {
  import P31._
  test("is 0 prime") {
    //assertThrows[RuntimeException](0.isPrime())
    assert(0.isPrime === false)
  }
  test("is 1 prime") {
    assert(1.isPrime === false)
  }
  test("is 2 prime") {
    assert(2.isPrime === true)
  }
  test("is 3 prime") {
    assert(3.isPrime === true)
  }
  test("is 4 prime") {
    assert(4.isPrime === false)
  }
  test("is 5 prime") {
    assert(5.isPrime === true)
  }
  test("is 6 prime") {
    assert(6.isPrime === false)
  }
  test("is 7 prime") {
    assert(7.isPrime === true)
  }
  test("is 8 prime") {
    assert(8.isPrime === false)
  }
  test("is 9 prime") {
    assert(9.isPrime === false)
  }
  test("is 10 prime") {
    assert(10.isPrime === false)
  }
  test("is 11 prime") {
    assert(11.isPrime === true)
  }
  test("is 12 prime") {
    assert(12.isPrime === false)
  }
  test("is 13 prime") {
    assert(13.isPrime === true)
  }
}

