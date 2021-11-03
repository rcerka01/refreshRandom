package codewars

import scala.annotation.tailrec

object ProdFIb extends App {

  def productFib(prod: Long): Array[Long] = {
    @tailrec
    def aux(current: Long, prew: Long): Array[Long] = {
      if (current * prew > prod) Array(prew, current, 0)
      else if (current * prew == prod) Array(prew, current, 1)
      else aux(current + prew, current)
    }
    aux(1,1)
  }

  println(productFib(74049690L).mkString(" "))
}
