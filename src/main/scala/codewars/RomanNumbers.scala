package codewars

object RomanNumbers extends App {

  def encode(arabic: Int): String = {
    def aux(i: Int, acc: String): String = {
      if ((i / 1000) > 0) aux(i % 1000, acc + ("M" * (i / 1000)))
      else if ((i / 900) > 0) aux(i % 900, acc + ("CM" * (i / 900)))
      else if ((i / 500) > 0) aux(i % 500, acc + ("D" * (i / 500)))
      else if ((i / 400) > 0) aux(i % 400, acc + ("CD" * (i / 400)))
      else if ((i / 100) > 0) aux(i % 100, acc + ("C" * (i / 100)))
      else if ((i / 90) > 0) aux(i % 90, acc + ("XC" * (i / 90)))
      else if ((i / 50) > 0) aux(i % 50, acc + ("L" * (i / 50)))
      else if ((i / 40) > 0) aux(i % 40, acc + ("XL" * (i / 40)))
      else if ((i / 10) > 0) aux(i % 10, acc + ("X" * (i / 10)))
      else if ((i / 9) > 0) aux(i % 9, acc + "IX")
      else if ((i / 5) > 0) aux(i % 5, acc + "V")
      else if ((i / 4) > 0) aux(i % 4, acc + "IV")
      else if ((i / 1) > 0) aux(i % 1, acc + ("I" * (i / 1)))
      else acc
    }
    aux(arabic, "")
  }

   println(encode(1478))
  
}


//assert(Roman.encode(1) === "I")
//assert(Roman.encode(3) === "III")
//assert(Roman.encode(4) === "IV")
//assert(Roman.encode(6) === "VI")
//assert(Roman.encode(14) === "XIV")
//assert(Roman.encode(21) === "XXI")
//assert(Roman.encode(89) === "LXXXIX")
//assert(Roman.encode(91) === "XCI")
//assert(Roman.encode(984) === "CMLXXXIV")
//assert(Roman.encode(1000) === "M")
//assert(Roman.encode(1666) === "MDCLXVI")
//assert(Roman.encode(1889) === "MDCCCLXXXIX")
//assert(Roman.encode(1989) === "MCMLXXXIX")
//assert(Roman.encode(2008) === "MMVIII")
