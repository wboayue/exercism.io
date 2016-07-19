import java.util.{Calendar, GregorianCalendar}

class Meetup(month: Int, year: Int) {
  import Meetup._

  def first(weekday: WeekDay): Calendar = {
    startOfMonth(month, year) next weekday
  }

  def second(weekday: WeekDay): Calendar = {
    1 weekFrom first(weekday)
  }

  def third(weekday: WeekDay): Calendar = {
    2 weeksFrom first(weekday)
  }

  def fourth(weekday: WeekDay): Calendar = {
    3 weeksFrom first(weekday)
  }

  def teenth(weekday: WeekDay): Calendar = {
    startOfMonth(month, year) teenth weekday
  }

  def last(weekday: WeekDay): Calendar = {
    endOfMonth(month, year) last weekday
  }

}

object Meetup {

  def apply(month: Int, year: Int) = new Meetup(month, year)

  def startOfMonth(month: Int, year: Int): Calendar = {
    new GregorianCalendar(year, month - 1, 1)
  }

  def endOfMonth(month: Int, year: Int): Calendar = {
    new GregorianCalendar(year, month, 1) addDays -1
  }

  implicit class MeetupCalendar(date: Calendar) {

    val Teenths = 13 to 19

    def addDays(num: Int) = {
      val copy = date.clone().asInstanceOf[Calendar]
      copy.add(Calendar.DATE, num)
      copy
    }

    def subtractDays(num: Int) = {
      addDays(num * -1)
    }

    def setDayOfMonth(num: Int) = {
      val copy = date.clone().asInstanceOf[Calendar]
      copy.set(Calendar.DATE, num)
      copy
    }

    def dayOfWeek() = {
      date.get(Calendar.DAY_OF_WEEK)
    }

    def next(weekday: WeekDay): Calendar = {
      val offset = weekday.day - date.dayOfWeek

      if (offset < 0) {
        date addDays 7 + offset
      } else {
        date addDays offset
      }
    }

    def last(weekday: WeekDay): Calendar = {
      val offset = date.dayOfWeek - weekday.day

      if (offset < 0) {
        date subtractDays (7 + offset)
      } else {
        date subtractDays offset
      }
    }

    def teenth(weekday: WeekDay): Calendar = {
      Teenths.map(date.setDayOfMonth(_))
        .find(_.dayOfWeek == weekday.day).get
    }

  }

  implicit class MeetupInt(num: Int) {

    def weeksFrom(date: Calendar): Calendar = {
      date addDays num * 7
    }

    def weekFrom(date: Calendar): Calendar = {
      weeksFrom(date)
    }

  }

  sealed abstract class WeekDay(val day: Int)
  case object Mon extends WeekDay(Calendar.MONDAY)
  case object Tue extends WeekDay(Calendar.TUESDAY)
  case object Wed extends WeekDay(Calendar.WEDNESDAY)
  case object Thu extends WeekDay(Calendar.THURSDAY)
  case object Fri extends WeekDay(Calendar.FRIDAY)
  case object Sat extends WeekDay(Calendar.SATURDAY)
  case object Sun extends WeekDay(Calendar.SUNDAY)

}