package codewars

object Sq extends App {


  def solution(a: Array[Int], b: Array[Int]): Double = {
    val pairs = a zip b
    (pairs map { item =>
      val abs = Math.abs(item._1.toDouble - item._2.toDouble)
      abs * abs
    }).sum / a.length
  }

  //println(solution(Array(1, 2, 3), Array(4, 5, 6)))
  println(solution(Array(10, 20, 10, 2), Array(10, 25, 5, -2)))
}
