package random

object TypeCLass2 extends App {

  case class Woman(name: String)
  case class Couple(names: String)
  val ann = Woman("Ann")
  val mari = Woman("Mari")

  // from implicit type class

  trait SomeTypeClass[T, A] {
    def add(a: T, b: T): A
  }

  def add[T, A](a: T, b: T)(implicit someTypeClass: SomeTypeClass[T, A]) = someTypeClass.add(a,b)

  implicit object Zin extends SomeTypeClass[Woman, Couple] {
    override def add(a: Woman, b: Woman): Couple = Couple(s"Mrs ${a.name} and Mrs ${b.name} from type class")
  }

  println(add(ann, mari))

  // from implicit function

  implicit def fromFunctionImplicit(a: Woman, b: Woman) =  Couple(s"Mrs ${a.name} and Mrs ${b.name} from function")
  def fromFunction(a: Woman, b: Woman)(implicit f: (Woman, Woman) => Couple) = f(a,b)

  println(fromFunction(ann, mari))

  // implicit class
  case class Man(name: String)
  val vic = Man("Victor")
  val el = Man("Eleonor")

  implicit class Ho(m: Man) {
    def addOtherMan(m2: Man) = Couple(s"Man couple $m and $m2")
  }

  println(vic.addOtherMan(el))

  // anonymous class
  val instanceOfAn = new SomeTypeClass[Man, Couple]() {
    override def add(a: Man, b: Man): Couple = Couple(s"Nice anonymus couple $a and $b")
  }

  println(instanceOfAn.add(vic, el))
}
