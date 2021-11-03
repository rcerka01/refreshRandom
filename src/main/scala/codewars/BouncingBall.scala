package codewars

import org.scalatest.funsuite.AnyFunSuite

import scala.annotation.tailrec

object BouncingBall {

  def bouncBall(h: Double, bounce: Double, window: Double): Int = {
    @tailrec
    def aux(hA: Double, bounceA: Double, windowA: Double, acc: Int): Int =
      if (hA <= windowA) acc
      else aux(hA * bounceA, bounceA, windowA, acc + 2)
    if (h <= 0 || bounce <= 0 || bounce >=1 || window >= h) { -1 }
    else {
      aux(h, bounce, window, -1)
    }
  }

}

class BouncingBallSpec extends AnyFunSuite {
  import BouncingBall._
  test("result must be") {
    assert(bouncBall(3, 0.66, 1.5) == 3)
    assert(bouncBall(10, 0.6, 10) == -1)
    assert(bouncBall(-5, 0.66, 1.5) == -1)
    assert(bouncBall(5, -1, 1.5) == -1)
  }
}
