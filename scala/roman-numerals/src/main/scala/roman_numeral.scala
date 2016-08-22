class RomanNumeral(number: Int) {

  def value: String = {
    val (translated, _) = RomanNumeral.ArabicToRoman.foldLeft(("", number)) { (acc, translation) =>
      val (abrabic, roman) = translation
      val (numerals, number) = acc

      (numerals + (roman * (number / abrabic)), number % abrabic)
    }

    translated
  }

}

object RomanNumeral {

  def apply(number: Int): RomanNumeral = new RomanNumeral(number)

  val ArabicToRoman = List[(Int, String)](
    1000 -> "M",
    900 -> "CM",
    500 -> "D",
    400 -> "CD",
    100 -> "C",
    90 -> "XC",
    50 -> "L",
    40 -> "XL",
    10 -> "X",
    9 -> "IX",
    5 -> "V",
    4 -> "IV",
    1 -> "I"
  )

}
