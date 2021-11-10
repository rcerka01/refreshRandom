package recursion

import scala.annotation.tailrec

object Fibonacci extends App {

  def fibonacci(number: Int): List[Int] = {

    @tailrec
    def aux(acc: List[Int]): List[Int] = {
      val next = acc.tail.head + acc.head
      if (next > number) acc
      else aux(next +: acc)
    }

    (if (number <= 0) List()
    else if (number == 1) List(1)
    else (aux(List(2,1)))).reverse
  }

  println(fibonacci(1009878679).slice(0,63))

}
