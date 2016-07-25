class Binary(number: String) {
  import Binary.ValidDigits

  def toDecimal(): Int = {
    if (isValid) {
      number.reverse.zipWithIndex.foldLeft(0) {
        case (acc, ('1', i))     => acc + BigInt(2).pow(i).toInt
        case (acc, (_digit, _i)) => acc
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