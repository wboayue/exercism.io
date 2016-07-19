import java.util.{Calendar, GregorianCalendar}

class Meetup(month: Int, year: Int) {
  import Meetup._

  def first(weekday: WeekDay): Calendar = {
    WeekDaySeq(month, year, weekday).head
  }

  def second(weekday: WeekDay): Calendar = {
    WeekDaySeq(month, year, weekday).drop(1).head
  }

  def third(weekday: WeekDay): Calendar = {
    WeekDaySeq(month, year, weekday).drop(2).head
  }

  def fourth(weekday: WeekDay): Calendar = {
    WeekDaySeq(month, year, weekday).drop(3).head
  }

  def teenth(weekday: WeekDay): Calendar = {
    WeekDaySeq(month, year, weekday)
      .filter(Meetup.Teenths contains _.get(Calendar.DATE))
      .head
  }

  def last(weekday: WeekDay): Calendar = {
    WeekDaySeq(month, year, weekday).last
  }

}

object WeekDaySeq {
  import Meetup.WeekDay

  def apply(month: Int, year: Int, weekday: WeekDay): Seq[Calendar] = {
    val startOfMonth = new GregorianCalendar(year, month - 1, 1)
    val endOfMonth = new GregorianCalendar(year, month, 1)

    var weekdays = Array.empty[Calendar]

    while (startOfMonth != endOfMonth) {
      if (startOfMonth.get(Calendar.DAY_OF_WEEK) == weekday.day) {
        weekdays = weekdays :+ startOfMonth.clone().asInstanceOf[Calendar]
      }
      startOfMonth.add(Calendar.DATE, 1)
    }

    weekdays
  }

}

object Meetup {

  val Teenths = (13 to 19).toSet

  def apply(month: Int, year: Int) = new Meetup(month, year)

  sealed abstract class WeekDay(val day: Int)
  case object Mon extends WeekDay(Calendar.MONDAY)
  case object Tue extends WeekDay(Calendar.TUESDAY)
  case object Wed extends WeekDay(Calendar.WEDNESDAY)
  case object Thu extends WeekDay(Calendar.THURSDAY)
  case object Fri extends WeekDay(Calendar.FRIDAY)
  case object Sat extends WeekDay(Calendar.SATURDAY)
  case object Sun extends WeekDay(Calendar.SUNDAY)

}