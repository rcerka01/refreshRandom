package random

import org.scalatest.funsuite.AnyFunSuite
import scala.annotation.tailrec

object CurrencyInt {

  def divideByNotes(amount: Int)(implicit notes: List[Int]): List[Int] = {
    @tailrec
    def aux(amount: Int, notes: List[Int], acc: List[Int]): List[Int] = {
      if (notes.isEmpty) acc
      else {
        val times = amount / notes.head
        val rest = amount % notes.head
        val resultList = acc ++ List.fill(times)(notes.head)
        aux(rest, notes.tail, resultList)
      }
    }
    if (amount <= 0) Nil
    else aux(amount, notes, Nil)
  }

}

class CurrencyIntTest extends AnyFunSuite {
  // notes: 50, 20, 10, 5, 2, 1
  implicit val listOfNotes: List[Int] = List(50, 20, 10, 5, 2, 1)

  test ("Is currencies correctly divided for 133") {
    val expectedReturn = List(50,50,20,10,2,1)
    val ret = CurrencyInt.divideByNotes(133)
    assert(expectedReturn === ret)
  }

  test ("Is currencies sum match with amount") {
    val ret = CurrencyInt.divideByNotes(2231).sum
    assert(2231 === ret)
  }

  test("Empty list for 0") {
    val ret = CurrencyInt.divideByNotes(0)
    assert(ret === Nil)
  }

  test("Empty list for negative") {
    val ret = CurrencyInt.divideByNotes(-5)
    assert(ret === Nil)
  }
}
