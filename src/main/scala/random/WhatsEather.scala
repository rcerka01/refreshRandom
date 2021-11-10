package random

object WhatsEither extends App {

  case class Dog()
  case class Cat()

  val d = Dog()
  val c = Cat()

  // val x: Either[Dog, Cat] = Left(d)
  val x: Either[Dog, Cat] = Right(c)

  x match {
    case Right(v) => println(s"I am cat: $v")
    case Left(v) => println(s"I am dog: $v")
  }
}
