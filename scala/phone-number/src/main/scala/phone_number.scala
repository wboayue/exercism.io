class PhoneNumber(raw: String) {

  val DefaultNumber = "0" * 10

  lazy val number: String = {
    filtered match {
      case num if isValidTenDigits(num) => num
      case num if isValidElevenDigits(num) => num.tail
      case _ => DefaultNumber
    }
  }

  private lazy val filtered: String = {
    raw.filter(_.isLetterOrDigit)
  }

  private def isValidTenDigits(num: String): Boolean = {
    num.length == 10
  }

  private def isValidElevenDigits(num: String): Boolean = {
    num.head == '1' && num.length == 11
  }

  lazy val areaCode: String = number.take(3)

  private lazy val coCode: String = number.substring(3, 6)

  private lazy val last4Digits: String = number.drop(6)

  override def toString: String = {
    s"(${areaCode}) ${coCode}-${last4Digits}"
  }

}