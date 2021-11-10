package codility

import scala.annotation.tailrec

object SmallestNotInArray extends App {

  def solution(a: Array[Int]): Int = {
    val max = a.max

    @tailrec
    def aux(current: Int): Int = {
      if (current >= max) max + 1
      else if ( a.count(_ == current) <= 0) current
      else aux(current + 1)
    }

    if (max < 0) 1
    else aux(1)
  }

  println(solution(Array(1, 3, 6, 4, 1, 2)))
  println(solution(Array(1, 2, 3)))
  println(solution(Array(-1, -3)))
}
