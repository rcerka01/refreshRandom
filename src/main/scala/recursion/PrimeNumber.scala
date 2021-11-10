package recursion

import scala.annotation.tailrec

object PrimeNumber extends App {

  def primes(number: Int): List[Int] = {
    @tailrec
    def auxForIsPrime(i: Int, acc: Int): Int = {
      if (acc >= i ) i
      else if ( (i % acc) == 0 ) -1
      else auxForIsPrime(i, acc + 1)
    }

    @tailrec
    def auxForList(current: Int, acc: List[Int]): List[Int] = {
      val mabyPrime = auxForIsPrime(current, 2)
      if (current > number) acc
      else if (mabyPrime > 0) auxForList(current + 1, acc :+ current)
      else auxForList(current + 1, acc)
    }

    auxForList(1, List())
  }

  println(primes(100))

}
