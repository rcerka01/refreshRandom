package random

import org.scalatest.funsuite.AnyFunSuite
import scala.annotation.tailrec

object CurrencyDouble {
  def divideByNotes(amount: Double)(implicit notes: List[Double]): List[Double] = {
    @tailrec
    def aux(amount: Double, notes: List[Double], acc: List[Double]): List[Double] = {
      if (notes.isEmpty) acc
      else {
        val times = amount / notes.head
        val rest = amount % notes.head
        val resultList = acc ++ List.fill(times.toInt)(notes.head)
        aux(rest, notes.tail, resultList)
      }
    }
    if (amount <= 0) Nil
    else aux(amount, notes, Nil)
  }
}

class CurrencyDoubleTest extends AnyFunSuite {
  // notes: 50, 20, 10, 5, 2, 1
  implicit val listOfNotes: List[Double] = List(50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01)

  test ("Is currencies correctly divided for 133") {
    val expectedReturn = List(50,50,20,10,2,1,0.5, 0.2, 0.1, 0.05, 0.02)
    val ret = CurrencyDouble.divideByNotes(133.87)
    assert(expectedReturn === ret)
  }

  test ("Is currencies sum match with amount") {
    val ret = CurrencyDouble.divideByNotes(2231).sum
    assert(2231 === ret)
  }

  test("Empty list for 0") {
    val ret = CurrencyDouble.divideByNotes(0)
    assert(ret === Nil)
  }

  test("Empty list for negative") {
    val ret = CurrencyDouble.divideByNotes(-5)
    assert(ret === Nil)
  }
}
