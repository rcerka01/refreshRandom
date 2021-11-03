package codewars

import scala.annotation.tailrec

object DigitPower extends App {

  def digPow(n: Int, p: Int): Int = {
    val ndig = n.toString.map(_.asDigit).toList

    @tailrec
    def aux(l: List[Int], currentP: Int, acc: Int): Int =
      if (l.isEmpty) acc
      else aux(l.tail, currentP + 1, acc + Math.pow(l.head, currentP).toInt)

    val sum = aux(ndig, p, 0)

    if (sum % n == 0) sum / n
    else -1
  }

  println(digPow(89,1))

}
