package random

trait Animal[T] {
  def kind(k: T): String
}

object TypeClasses3Confirmation extends App {

  def specificKind[T](k: T)(implicit animal: Animal[T]): String = animal.kind(k)

  case class Dog()
  case class Cat()

  implicit object Zio extends Animal[Dog] {
    override def kind(k: Dog): String = "Hallo from Dog"
  }

  val dog = Dog()
  val cat = Cat()

  println(specificKind(dog))
  // specificKind(cat) // no implicit object
}
