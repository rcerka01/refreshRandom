package random

import scala.util.Try

object TryVtry extends App {

 val x = Try {
   throw new RuntimeException("fuck")
    32
  }

  val y = try {
    //throw new RuntimeException("fuck")
    33
  }

  println(x) // Return Success(32) or Failure(e). It is a monadic wrapper to chain operations
  println(y) // Return 32 or fails.
}
