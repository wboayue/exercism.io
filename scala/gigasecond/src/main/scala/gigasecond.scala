import java.util.{Calendar}

class Gigasecond(birthday: Calendar) {
  import Gigasecond.GigasecondCalendar

  def date(): Calendar = {
    birthday addSeconds Gigasecond.Duration
  }
}

object Gigasecond {

  val Duration = BigInt(10).pow(9).toInt

  def apply(birthday: Calendar) = new Gigasecond(birthday)

  implicit class GigasecondCalendar(date: Calendar) {

    def addSeconds(duration: Int): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
      result.add(Calendar.SECOND, duration)
      result
    }

  }
}
