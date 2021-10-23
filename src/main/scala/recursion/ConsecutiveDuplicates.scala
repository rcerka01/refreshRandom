package recursion

import scala.annotation.tailrec

object ConsecutiveDuplicates extends App {

  val l = List(1,1,1,1,3,3,3,3,4,4,7,7)

  def cd(l: List[Int]): List[(Int, Int)] = {
    @tailrec
    def aux(l: List[Int], acc: List[(Int, Int)], count: Int): List[(Int, Int)] = {
      if (l.tail.isEmpty) acc :+ (l.head, count)
      else if (l.head == l.tail.head) aux(l.tail, acc, count + 1)
      else aux(l.tail, acc :+ (l.head, count), 1)
    }
    aux(l, Nil, 1)
  }

  println(cd(l))


}
