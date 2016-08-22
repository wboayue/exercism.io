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
    tuple match {
      case (digit, power) if List(1, 2, 3) contains digit => numeral(power) * digit
      case (digit, power) if 4 == digit => numeral(power) + midNumeral(power)
      case (digit, power) if 5 == digit => midNumeral(power)
      case (digit, power) if List(6, 7, 8) contains digit => midNumeral(power) + (numeral(power) * (digit - 5)) 
      case (digit, power) if 9 == digit => numeral(power) + numeral(power + 1)
    }
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
