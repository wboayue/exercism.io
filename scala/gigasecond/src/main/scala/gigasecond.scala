import java.util.{Calendar, GregorianCalendar}

class Gigasecond(birthday: GregorianCalendar) {

  def date(): GregorianCalendar = {
    val gigaSecondAnniversary = birthday.clone().asInstanceOf[GregorianCalendar]
    gigaSecondAnniversary.add(Calendar.SECOND, Gigasecond.Length)
    gigaSecondAnniversary
  }

}

object Gigasecond {

  val Length = BigInt(10).pow(9).toInt

  def apply(birthday: GregorianCalendar) = new Gigasecond(birthday)

}
