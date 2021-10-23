package random

import org.scalatest.funsuite.AnyFunSuite
import scala.collection.parallel.CollectionConverters._


object Small {

  // in parallel
  List(1,2,3).par.map(_ + 1)

  // is two element sum equal
  def isComb(l: List[Int], i: Int): Boolean = (l flatMap (x => l.tail map (y => if (x+y == i) true else false))).max

}

class SmallTest extends AnyFunSuite {
  import Small._

  test("Is combination matching") {
    val list = List(9, 10, 15, 3, 7)
    val result = isComb(list, 17)
    assert(result === true)
  }
  test("Is combination not matching") {
    val list = List(9, 10, 15, 3, 19)
    val result = isComb(list, 17)
    assert(result === false)
  }
}
