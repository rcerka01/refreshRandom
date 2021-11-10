package random

object Enums extends App {

  // one way
  object MyEnum extends Enumeration {
    type MyEnum = Value
    val ONE, TWO, THREE = Value
  }
  println(MyEnum.TWO)

  // other way Sealed trait
  sealed trait Number
  case object FIRST extends Number
  case object SECOND extends Number
  case object THIRD extends Number

  object FAKE

  val x: Number = FIRST
  //val z: Number = FAKE // wont compilen // Enums.Fake.type
  println(x)


}
