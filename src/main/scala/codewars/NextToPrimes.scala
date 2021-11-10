package codewars

import scala.annotation.tailrec

object NextToPrimes extends App {

  def minimumNumber(numbers: Seq[Int]): Int = {
    val nominal = numbers.sum

    def findIfNumberIsPrime(number: Int): Boolean = {
      @tailrec
      def aux(i: Int): Boolean =
        if (i >= number) true
        else if (number % i == 0) false
        else aux(i + 1)
      aux(2)
    }

    @tailrec
    def findNextPrime(i: Int): Int =
      if (findIfNumberIsPrime(i)) i
      else findNextPrime(i + 1)

    findNextPrime(nominal) - nominal
  }

  println(minimumNumber(List(2,12,8,4,6)))

}
