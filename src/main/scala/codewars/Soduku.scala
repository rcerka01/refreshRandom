package codewars

object Soduku extends App {

    def isValid(board: Array[Array[Int]]): Boolean = {

      def isValidLine(l: Array[Int]): Boolean = l.toSet.size == 9 && l.toSet.sum == 45 && !l.contains(0)

      val turn = for (i <- 0 to 8) yield {
        board map (_(i))
      }

      ( board forall isValidLine ) && ( turn forall isValidLine )
    }

  println(isValid(Array(
  Array(2, 3, 4, 5, 6, 7, 8, 9, 1),
  Array(4, 5, 6, 7, 8, 9, 1, 2, 3),
  Array(5, 6, 7, 8, 9, 1, 2, 3, 4),
  Array(6, 7, 8, 9, 1, 2, 3, 4, 5),
  Array(7, 8, 9, 1, 2, 3, 4, 5, 6),
  Array(8, 9, 1, 2, 3, 4, 5, 6, 7),
  Array(9, 1, 2, 3, 4, 5, 6, 7, 8)
  )))

  //isValid(Array(Array(1,2), Array(3,4)))
}
