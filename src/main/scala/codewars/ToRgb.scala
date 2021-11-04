package codewars

object ToRgb extends App {

  def rgb(r: Int, g: Int, b: Int): String = {

    def toHex(i: Int): String = i match {
      case 0 => "0"
      case 1 => "1"
      case 2 => "2"
      case 3 => "3"
      case 4 => "4"
      case 5 => "5"
      case 6 => "6"
      case 7 => "7"
      case 8 => "8"
      case 9 => "9"
      case 10 => "A"
      case 11 => "B"
      case 12 => "C"
      case 13 => "D"
      case 14 => "E"
      case 15 => "F"
      case _ => ""
    }

    def intToHex(i: Int): String = {
      if (i < 0) {
        "00"
      } else if (i > 255) {
        "FF"
      } else {
        val pre = toHex(i / 16)
        val pos = toHex(i % 16)
        pre + pos
      }
    }

    intToHex(r) + intToHex(g) + intToHex(b)
  }

  println(rgb(0, 0, 0)) // 000000
  println(rgb(1, 2, 3)) // 010203
  println(rgb(255, 255, 255)) // FFFFFF
  println(rgb(254, 253, 252)) // FEFDFC
  println(rgb(-20, 275, 125)) // 00FF7D
  println(rgb(42, 85, 190)) // 00FF7D
}
