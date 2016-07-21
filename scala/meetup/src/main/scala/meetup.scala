import java.util.{Calendar, GregorianCalendar}

class Meetup(month: Int, year: Int) {
  import Meetup._

  def first(weekday: WeekDay): Calendar = {
    findAll(weekday).in(month, year).head
  }

  def second(weekday: WeekDay): Calendar = {
    findAll(weekday).in(month, year)(1)
  }

  def third(weekday: WeekDay): Calendar = {
    findAll(weekday).in(month, year)(2)
  }

  def fourth(weekday: WeekDay): Calendar = {
    findAll(weekday).in(month, year)(3)
  }

  def teenth(weekday: WeekDay): Calendar = {
    findAll(weekday).in(month, year)
      .filter(Teenths contains _.get(Calendar.DATE))
      .head
  }

  def last(weekday: WeekDay): Calendar = {
    findAll(weekday).in(month, year).last
  }

}

class CalendarQuery(weekday: Meetup.WeekDay) {

  def in(month: Int, year: Int): IndexedSeq[Calendar] = {
    val startOfMonth = new GregorianCalendar(year, month - 1, 1)
    val endOfMonth = new GregorianCalendar(year, month, 1)
    var weekdays = Vector.empty[Calendar]

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

  def apply(month: Int, year: Int): Meetup = new Meetup(month, year)

  def findAll(weekday: WeekDay): CalendarQuery = {
    new CalendarQuery(weekday)
  }

  val Teenths = (13 to 19).toSet

  sealed abstract class WeekDay(val day: Int)
  case object Mon extends WeekDay(Calendar.MONDAY)
  case object Tue extends WeekDay(Calendar.TUESDAY)
  case object Wed extends WeekDay(Calendar.WEDNESDAY)
  case object Thu extends WeekDay(Calendar.THURSDAY)
  case object Fri extends WeekDay(Calendar.FRIDAY)
  case object Sat extends WeekDay(Calendar.SATURDAY)
  case object Sun extends WeekDay(Calendar.SUNDAY)

}
