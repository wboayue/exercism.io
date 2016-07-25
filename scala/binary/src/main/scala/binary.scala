class Binary(number: String) {
  import Binary.ValidDigits

  def toDecimal(): Int = {
    if (isValid) {
      number.foldLeft(0) {
        case (acc, '1') => acc * 2 + 1
        case (acc, '0') => acc * 2
      }
    } else {
      0
    }
  }

  def isValid(): Boolean = {
    number.forall(ValidDigits.contains(_))
  }
}

object Binary {
  def apply(number: String) = new Binary(number)
  val ValidDigits = Set('0', '1')
}