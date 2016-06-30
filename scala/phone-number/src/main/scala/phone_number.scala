class PhoneNumber(raw: String) {

  lazy val number: String = {
    filtered match {
      case num if PhoneNumber.isValidTenDigits(num) => num
      case num if PhoneNumber.isValidElevenDigits(num) => num.tail
      case _ => PhoneNumber.InvalidNumber
    }
  }

  private lazy val filtered: String = {
    raw.filter(_.isLetterOrDigit)
  }

  lazy val areaCode: String = number.take(3)

  private lazy val prefix: String = number.substring(3, 6)

  private lazy val lineNumber: String = number.drop(6)

  override def toString: String = {
    s"(${areaCode}) ${prefix}-${lineNumber}"
  }

}

object PhoneNumber {

  val InvalidNumber = "0" * 10

  def isValidTenDigits(num: String): Boolean = {
    num.length == 10
  }

  def isValidElevenDigits(num: String): Boolean = {
    num.head == '1' && num.length == 11
  }

}