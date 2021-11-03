package codewars

import org.scalatest.funsuite.AnyFunSuite

import scala.annotation.tailrec

object MultiplesOf3Or5 {

  def solution(number: Int): Long = {
    @tailrec
    def aux(numb: Int, acc: Long): Long =
      if (numb <= 0) acc
      else if (numb % 5 == 0 || numb % 3 == 0) aux(numb - 1, acc + numb)
      else aux(numb -1, acc)

    if (number < 0) 0
    else aux(number - 1, 0)
  }
}

class MultiplesOf3Or5Spec extends AnyFunSuite {
  import MultiplesOf3Or5._

  test("It has to pass") {
     assert(solution(0) === 0)
     assert(solution(10) === 23)
     assert(solution(15) === 45)
     assert(solution(16) === 60)
     assert(solution(20) === 78)
  }
}
