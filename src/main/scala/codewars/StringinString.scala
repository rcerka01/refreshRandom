package codewars

import org.scalatest.funsuite.AnyFunSuite

object StringInString {

  def inArray(array1: Array[String], array2: Array[String]): Array[String] =
    array2.flatMap { a2 =>
      array1.filter { a1 =>
        a2 contains a1
      }
    }
    .distinct
    .sorted
}



class StringInString extends AnyFunSuite {
  import StringInString._

  test("pass basic tests") {
    val a1 = Array("live", "arp", "strong")
    val a2 = Array("lively", "alive", "harp", "sharp", "armstrong")
    val r = Array("arp", "live", "strong")
    assert(inArray(a1, a2) === r)
  }
}
