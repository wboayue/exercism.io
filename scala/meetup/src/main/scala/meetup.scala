import java.util.{Calendar, GregorianCalendar}

class Meetup(month: Int, year: Int) {
  import Meetup.WeekDay
  import Meetup.MeetupCalendar
  import Meetup.MeetupInt

  def first(weekday: WeekDay): Calendar = {
    Meetup.startOfMonth(month, year) next weekday
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
    Meetup.startOfMonth(month, year) teenth weekday
  }

  def last(weekday: WeekDay): Calendar = {
    Meetup.endOfMonth(month, year) last weekday
  }

}

object Meetup {

  def apply(month: Int, year: Int) = new Meetup(month, year)

  def startOfMonth(month: Int, year: Int): Calendar = {
    new GregorianCalendar(year, month - 1, 1)
  }

  def endOfMonth(month: Int, year: Int): Calendar = {
    val monthsEnd = new GregorianCalendar(year, month, 1)
    monthsEnd.add(Calendar.DATE, -1)
    monthsEnd
  }

  sealed abstract class WeekDay(val day: Int)
  case object Mon extends WeekDay(Calendar.MONDAY)
  case object Tue extends WeekDay(Calendar.TUESDAY)
  case object Wed extends WeekDay(Calendar.WEDNESDAY)
  case object Thu extends WeekDay(Calendar.THURSDAY)
  case object Fri extends WeekDay(Calendar.FRIDAY)
  case object Sat extends WeekDay(Calendar.SATURDAY)
  case object Sun extends WeekDay(Calendar.SUNDAY)

  implicit class MeetupCalendar(date: Calendar) {

    val Teenths = 13 to 19

    def next(weekday: WeekDay): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
      while (result.get(Calendar.DAY_OF_WEEK) != weekday.day) {
        result.add(Calendar.DATE, 1)
      }
      result
    }

    def last(weekday: WeekDay): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
      while (result.get(Calendar.DAY_OF_WEEK) != weekday.day) {
        result.add(Calendar.DATE, -1)
      }
      result
    }

    def teenth(weekday: WeekDay): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
      val day = Teenths.filter{
        (num) => {
          result.set(Calendar.DATE, num)
          result.get(Calendar.DAY_OF_WEEK) == weekday.day
        }
      }
      result.set(Calendar.DATE, day.head)
      result
    }

  }

  implicit class MeetupInt(num: Int) {

    def weeksFrom(date: Calendar): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
      result.add(Calendar.DATE, num * 7)
      result
    }

    def weekFrom(date: Calendar): Calendar = {
      weeksFrom(date)
    }

  }

}