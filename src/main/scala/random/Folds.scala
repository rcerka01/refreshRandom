package random

import scala.collection.parallel.CollectionConverters.ImmutableIterableIsParallelizable

object Folds extends App {

  val li = List(1,2,3,4)
  case class Person(name: String, age: Int)
  val lp = List(Person("Bob", 12), Person("Ann", 32))

  // FOLD
  // no order
  // start value can be just basic type (like "" or 0). List[Int] will not work
  val f_xi = li.fold(2)((a,b) => a + b) // 18
  val f_xip = li.par.fold(2)((a,b) => a + b) // 18 // use more often with parallel computation
  val f_xis = li.fold("")((a,b) => a + b.toString) // 1234
  // val f_lp = lp.fold(List[Person]())((a,b) => a :+ b) // will not work. Only if toString

  // FOLD LEFT
  val fl_xil = li.foldLeft(List[Int]())((a,b) => a :+ b) // List(1,2,3,4)   starts with List[Int]()  !!!
  val fl_xilr = li.foldLeft(List[Int]())((a,b) => b +: a) // List(4,3,2,1)   starts with List[Int]()  !!!
  val fl_xilrp = li.par.foldLeft(List[Int]())((a,b) => b +: a) // List(4,3,2,1)   starts with List[Int]()  !!! // can be parallel
  val fl_xilb = li.foldLeft(true)((a,b: Int) => a || b > 2) // true
  val fl_lp = lp.foldLeft(List[Person]())((a,b) => a :+ b.copy(name = s"Mr ${b.name}" ))


  // FOLD Right
  val fr_xil = li.foldRight(List[Int]())((a,b) => a +: b) // List(1,2,3,4)   starts with List[Int]()  !!!

  println(fl_lp)
}
