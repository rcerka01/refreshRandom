package random

import org.scalatest.funsuite.AnyFunSuite

object FirstNotrepeating extends App {

  implicit class Fnre(s: String) {
    def fnre: String = {
      if (s.nonEmpty) (s map { element => s.filter(_ == element) }).filter(_.length == 1).head
      else ""
    }
  }
}

class FirstNotRepeatingSpec extends AnyFunSuite {
  import FirstNotrepeating._
  test("return first not repeating string element") {
    assert("eeffacddr".fnre === "a")
    assert("effacddr".fnre  === "e")
    assert("eeffaaccddr".fnre  === "r")
    assert("e".fnre  === "e")
    assert("".fnre  === "")
  }
}
