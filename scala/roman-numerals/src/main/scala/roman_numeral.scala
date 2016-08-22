import scala.annotation.tailrec 

class RomanNumeral(number: Int) {
  import RomanNumeral.{components, toRoman}

  def value: String = {
    components(number)
      .map(toRoman(_))
      .mkString
  }

}

object RomanNumeral {
  
  def apply(number: Int): RomanNumeral = new RomanNumeral(number)

  def components(number: Int): Seq[(Int, Int)] = {
    digits(number)
      .reverse
      .zipWithIndex
      .filter{case (num, power) => num > 0}
      .reverse
  }

  @tailrec
  def digits(number: Int, acc: List[Int] = List.empty[Int]): List[Int] = {
    val div = number / 10
    val rem = number % 10

    if (div == 0) {
      rem :: acc
    } else {
      digits(div, rem :: acc)
    }
  }

  def toRoman(tuple: (Int, Int)): String = {
    val (digit, power) = tuple

    digit match {
      case 1 | 2 | 3 => duplicate(numeral(power), digit)
      case 4         => numeral(power) + midNumeral(power)
      case 5         => midNumeral(power)
      case 6 | 7 | 8 => midNumeral(power) + duplicate(numeral(power), digit - 5) 
      case 9         => numeral(power) + numeral(power + 1)
    }
  }

  def duplicate(s: String, times: Int) = {
    s * times
  }

  def numeral(power: Int) = power match {
    case 0 => "I"
    case 1 => "X"
    case 2 => "C"
    case 3 => "M"
  }

  def midNumeral(power: Int) = power match {
    case 0 => "V"
    case 1 => "L"
    case 2 => "D"
  }

} 
