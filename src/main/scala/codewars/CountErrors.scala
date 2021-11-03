package codewars

object CountErrors extends App {

  def printerError(s: String): String = {
    val allowed = "abcdefghijklm"
    val errors = s.map(letter => if (!allowed.contains(letter)) letter else "").mkString.length
    s"$errors/${s.length}"
  }

  println(printerError("aaabbbbhaijjjm"))
}
