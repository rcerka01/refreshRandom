package random

import org.scalatest.funsuite.AnyFunSuite

// TYPE CLASSES is more like pattern
// It is Ad Hoc polimorphism for generic type subsidise inhance behavior

object TypeClasses {

  trait Operation[T] {
    def sum(l: List[T]): T
  }

  implicit object IntOperations extends Operation[Int] {
    override def sum(l: List[Int]): Int = l.sum
  }

  implicit object StringOperations extends Operation[String] {
    override def sum(l: List[String]): String = l.mkString("")
  }

  def elementSum[T](l: List[T])(implicit sumOperation: Operation[T]): T = sumOperation.sum(l)

  // not compile
  //elementSum(List(true, true, false))
}

class TypeClassesSpec extends AnyFunSuite {
  import TypeClasses._

  test("Typeclass bounded to String") {
    val ls: List[String] = List("we ", "are ", "happy")
    val toTest: String = elementSum(ls)
    assert(toTest === "we are happy")
  }

  test("Typeclass bounded to Int") {
    val ls: List[Int] = List(1,2,3)
    val toTest:Int = elementSum(ls)
    assert(toTest === 6)  }
}
