package codility

import scala.annotation.tailrec

object BinaryGap extends App {

  def intToBin(i: Int): List[Int] = {
    @tailrec
    def aux(i: Int, acc: List[Int]): List[Int] =
      if (i == 0) acc
      else aux(i / 2, i % 2 +: acc)
    aux(i, List())
  }

  def findGap(i: Int): Int = {
    @tailrec
    def aux(l: List[Int], acc: List[Int], prevElement: Int, currentCount: Int): List[Int] = {
      if (l.isEmpty) acc
      else if (l.head == 0 && prevElement == 1) aux(l.tail, acc, 0, currentCount + 1)
      else if (l.head == 1 && prevElement == 0) aux(l.tail, acc :+ currentCount, 1, 0)
      else if (l.head == 0 && prevElement == 0) aux(l.tail, acc, 0, currentCount + 1)
      else aux(l.tail, acc, prevElement, currentCount)
    }
    val li = intToBin(i)
    val gapList =
      if (li.nonEmpty) aux(li, List(), 0, 0)
      else List()
    if (gapList.isEmpty) 0 else gapList.max
  }

  println(findGap(20))
  println(findGap(1041))
  println(findGap(32))
  println(findGap(15))
  println(findGap(0))



}
