import java.util.{Calendar, GregorianCalendar}

class Meetup(month: Int, year: Int) {
  import Meetup.WeekDay
  import Meetup.MeetupCalendar
  import Meetup.MeetupInt
  
  val startOfMonth: Calendar = Meetup.startOfMonth(month, year)
//  val startDayOfWeek: WeekDay = startOfMonth.dayOfWeek

  def first(weekday: WeekDay): Calendar = {
    startOfMonth next weekday
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
    startOfMonth teenth weekday
  }

  def last(weekday: WeekDay): Calendar = {
    startOfMonth last weekday
  }

}

object Meetup {

  def apply(month: Int, year: Int) = new Meetup(month, year)

  def startOfMonth(month: Int, year: Int): Calendar = {
    new GregorianCalendar(year, month, 1)
  }

  sealed trait WeekDay
  case object Mon extends WeekDay
  case object Tue extends WeekDay
  case object Wed extends WeekDay
  case object Thu extends WeekDay
  case object Fri extends WeekDay
  case object Sat extends WeekDay
  case object Sun extends WeekDay

  implicit class MeetupCalendar(date: Calendar) {

    def next(weekday: WeekDay): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
//      result.add(Calendar.SECOND, duration)
      result
    }

    def last(weekday: WeekDay): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
//      result.add(Calendar.SECOND, duration)
      result
    }

    def teenth(weekday: WeekDay): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
//      result.add(Calendar.SECOND, duration)
      result
    }

  }

  implicit class MeetupInt(num: Int) {

    def weeksFrom(date: Calendar): Calendar = {
      val result = date.clone().asInstanceOf[Calendar]
//      result.add(Calendar.SECOND, duration)
      result
    }

    def weekFrom(date: Calendar): Calendar = {
      weeksFrom(date)
    }

  }

}