package codewars

import scala.annotation.tailrec

object ListOfListsWith1 extends App {
  def pyramid(n: Int): List[List[Int]] = {
    @tailrec
    def aux(i: Int, acc: List[List[Int]]): List[List[Int]] =
      if (i >= n) acc
      else aux(i + 1, acc :+ (Array.fill(i + 1)(1)).toList )
    aux(0, List())
  }

  println(pyramid(0))
  println(pyramid(1))
  println(pyramid(2))
  println(pyramid(3))

}
