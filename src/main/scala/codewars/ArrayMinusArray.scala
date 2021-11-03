package codewars

import org.scalatest.funsuite.AnyFunSuite

object ArrayMinusArray {

  def arrayDiff(a: Seq[Int], b: Seq[Int]) =
    a filterNot b.contains
}

class ArrayMinusArraySpec extends AnyFunSuite {
  import ArrayMinusArray._

  test("result must be") {
    val tests = Seq(
      (Seq(1, 2), Seq(1), Seq(2)),
      (Seq(1, 2, 2), Seq(1), Seq(2, 2)),
      (Seq(1, 2, 2), Seq(2), Seq(1)),
      (Seq(1, 2, 2), Seq(), Seq(1, 2, 2)),
      (Seq(), Seq(1, 2), Seq()),
      (Vector(-12, -12, -9, -13, 16, 2, -7, -8, -14, 6, -3, 16), Vector(6, 19), Vector(-12, -12, -9, -13, 16, 2, -7, -8, -14, -3, 16))
    )

    tests.foreach { case (a, b, expected) =>
        assert(arrayDiff(a, b) == expected)
      }
  }
}
