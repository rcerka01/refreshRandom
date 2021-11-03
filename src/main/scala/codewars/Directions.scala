package codewars

import scala.annotation.tailrec

object Directions extends App {

  def dirReduc(arr: Array[String]): Array[String] = {
    val n = "NORTH"
    val s = "SOUTH"
    val e = "EAST"
    val w = "WEST"

    def auxCompare(d1: String, d2: String): Boolean =
      (d1 == n && d2 == s) || (d1 == s && d2 == n) || (d1 == e && d2 == w) || (d1 == w && d2 == e)

    @tailrec
    def aux(arr: Array[String], acc: Array[String], updates: Int): Array[String] = {
        if ((arr.isEmpty || arr.tail.isEmpty) && updates == 0) acc ++ arr
        else if ((arr.isEmpty || arr.tail.isEmpty) && updates > 0) { if (arr.head.nonEmpty) aux(acc :+ arr.head, Array(), 0) else  aux(acc, Array(), 0) }
        else if (auxCompare(arr.head, arr.tail.head)) aux(arr.tail.tail, acc, updates + 1)
        else aux(arr.tail, acc :+ arr.head, updates)
    }

  aux(arr, Array(),0)
  }

  println(s"Result: " + dirReduc(Array("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")).mkString(" ")) // WEST
  println(s"Result: " + dirReduc(Array("NORTH", "WEST", "SOUTH", "EAST")).mkString(" ")) // "NORTH", "WEST", "SOUTH", "EAST"
  println(s"Result: " + dirReduc(Array("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")).mkString(" ")) // NORTH
  println(s"Result: " + dirReduc(Array()).mkString(" ")) // NORTH
}
