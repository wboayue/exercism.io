import collection.immutable.ListMap

class PhoneNumber(raw: String) {

  val (areaCode, prefix, lineNumber) = PhoneNumber.parse(raw)

  val number: String = s"${areaCode}${prefix}${lineNumber}"

  override def toString: String = {
    s"(${areaCode}) ${prefix}-${lineNumber}"
  }

}

object PhoneNumber {

  val InvalidNumber = ("000", "000", "0000")
  val PhoneNumberPattern = s"""1?(\\d{3})(\\d{3})(\\d{4})""".r

  def parse(raw: String): (String, String, String) = {
    val digits = raw.filter(_.isDigit)

    digits match {
      case PhoneNumberPattern(areaCode, prefix, lineNumber) => (areaCode, prefix, lineNumber)
      case _ => InvalidNumber
    }
  }

}