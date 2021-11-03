package codewars

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.annotation.tailrec

object CountSmilyFaces {

  def countSmileys(vec: Vector[String]): Int = {
    @tailrec
    def aux(s: String, eye: Int, mouth: Int): String = {
      if (s.isEmpty) { if (eye == 1 && mouth == 1) "1" else "0" }
      else {
        if ( mouth == 0 && (s.head.toString == ":" || s.head.toString == ";") ) aux(s.tail, eye + 1, mouth)
        else if ( eye == 1 && ( s.head.toString == ")" || s.head.toString == "D") ) aux(s.tail, eye, mouth + 1)
        else aux(s.tail, eye, mouth)
      }
    }
    def auxIsValidChar(s: String): Boolean = {
      val l = s.toList.map(_.toString)
      val validLength = l.count(_ == ":") +
        l.count(_ == ";") +
        l.count(_ == ")") +
        l.count(_ == "D") +
        l.count(_ == "-") +
        l.count(_ == "~")
      s.length == validLength
    }
    vec.map { s =>
      if ( auxIsValidChar(s))
        aux(s,0,0).toInt
      else
        0
    }.sum
  }

}

class CountSmilyFacesSpec extends AnyFunSuite {
  import CountSmilyFaces._

  test("Count must be") {
    countSmileys(Vector.empty) shouldBe 0
    countSmileys(Vector(":D",":~)",";~D",":)")) shouldBe 4
    countSmileys(Vector(":)",":(",":D",":O",":;")) shouldBe 2
    countSmileys(Vector(";]", ":[", ";*", ":$", ";-D")) shouldBe 1
  }

}
