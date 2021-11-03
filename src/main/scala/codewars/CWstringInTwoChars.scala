package codewars

import org.scalatest.funsuite.AnyFunSuite

import scala.annotation.tailrec

object CWstringInTwoChars {

    def solution(s: String): List[String] = {
      @tailrec
      def aux(l:List[String], current:List[String], acc:List[String]): List[String] =
        if (l.isEmpty) {
          if (current.length == 1) acc :+ (current.head + "_")
          else if (current.length == 2) acc :+ current.head
          else acc
        } else if (current.length == 0 ) { aux(l.tail, List(l.head), acc) }
        else aux(l.tail, List(), acc :+ (current.head + l.head))
      aux(s.toList.map(_.toString), List(), List())
    }

}

class CWstringInTwoCharsSpec extends AnyFunSuite {
  import CWstringInTwoChars._

  test("check results") {
    assert(solution("abcdef") === List("ab","cd","ef"))
    assert(solution("abcdefg") === List("ab","cd","ef","g_"))
  }
}
