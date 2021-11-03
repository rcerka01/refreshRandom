package codewars

import scala.annotation.tailrec

object JosephusSuvivor extends App {

  def josephusSurvivor(n: Int, k: Int): Int = {

    val array = (for (i <- 1 to n) yield i).toVector
    @tailrec
    def aux(l: Vector[Int], acc: Vector[Int], current: Int): Int = {
      if (acc.length + 1 == n) array.diff(acc)(0)
      else if (current <= l.length -1) aux(l, acc :+ l(current), current + k)
      else  aux(l.diff(acc), acc, current - l.length)

    }
    aux(array, Vector(), k - 1)

  }

//  println(s"Result: ${josephusSurvivor(7, 3)}") // 4
//  println(s"Result: ${josephusSurvivor(40, 3)}") // 28
//  println(s"Result: ${josephusSurvivor(11, 19)}") // 10 19

  println(s"Result: ${josephusSurvivor(3818, 2639)}") // 1348
}
