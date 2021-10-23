package random


class SomeClass(val i: Int, s: String) {
  private val secret = "dark"
  def incrementing = i + 1
}

object SomeClass {
  def apply(i: Int, s: String): SomeClass = new SomeClass(i, s)

  def getSecret(i: Int, s: String) = (new SomeClass(i, s)).secret
}


object CompanionObjects extends App {
  val sc = SomeClass(1, "a")
  println(sc.i)
  println(SomeClass.getSecret(2, "b"))
}
