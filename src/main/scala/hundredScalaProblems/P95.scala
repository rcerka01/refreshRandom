package hundredScalaProblems

import org.scalatest.funsuite.AnyFunSuite

import scala.annotation.tailrec

// P95 (**) English number words.
// On financial documents, like checks, numbers must sometimes be written in full words.
// Example: 175 must be written as one-seven-five. Write a function fullWords(num: Int) to print (non-negative) integer numbers in full words.

object P95 {
  def digitToWord(i: Int): String = i match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
    case 5 => "five"
    case 6 => "six"
    case 7 => "seven"
    case 8 => "eight"
    case 9 => "nine"
    case 0 => "zero"
    case _ => throw new RuntimeException("Digit not exist")
  }

  def numberToWords(i: Int): String = {
    def aux(num: Int, acc: List[String]): List[String] = {
      if ((num / 10) > 0 ) acc ++ aux(num / 10, List("-" + digitToWord(num % 10)))
      else acc :+ digitToWord(num % 10)
    }
    aux(i, Nil).reverse.mkString
  }
}

class P95Test extends AnyFunSuite {
  test("175 must be written as one-seven-five") {
    assert("one-seven-five" === P95.numberToWords(175))
  }
  test("5752019 must be written as one-seven-five") {
    assert("five-seven-five-two-zero-one-nine" === P95.numberToWords(5752019))
  }
  test("5 must be written as five in digitToWord converter") {
    assert("five" === P95.digitToWord(5))
  }
}
