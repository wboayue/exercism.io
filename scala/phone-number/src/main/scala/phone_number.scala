class PhoneNumber(raw: String) {

  val DefaultNumber = "0000000000"

  lazy val number: String = {
    filtered match {
      case num if isValidTenDigits(num) => filtered
      case num if isValidElevenDigits(num) => filtered.tail
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

  lazy val areaCode: String = {
    number.substring(0, 3)
  }

  override def toString: String = {
    val npaCode = number.take(3)
    val coCode = number.take(6).drop(3)
    val digits = number.drop(6)

    s"(${npaCode}) ${coCode}-${digits}"
  }

}