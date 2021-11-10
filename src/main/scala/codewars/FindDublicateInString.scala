package codewars

class FindDublicateInString extends App {

  def duplicateEncode(word: String): String = {
    word.toLowerCase.map { item =>
      if (word.count(_ == item) > 1 ) ")"
      else "("
    }.toString
  }
}
