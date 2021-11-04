package codewars

import codewars.BagelSolver.Bagel

object BagelSolver {

  class Bagel {
    final def getValue = 3
  }

  object getBagel {
    val getValue = 4
  }

//  def getBagel: Bagel = {
//    new Bagel {
//    }
//  }
}

object OverrideFinal extends App {
//  val b: Bagel = BagelSolver.getBagel
//  println(b.getValue)
}
