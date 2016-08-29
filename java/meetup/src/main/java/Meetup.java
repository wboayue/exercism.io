import java.time.DayOfWeek;
import java.time.YearMonth;
import java.tile.LocalDate;

public class Meetup {
  
  private YearMonth month;

  public Meetup(int month, int year) {
    this.month = YearMonth.of(year, month);
  }

  public String day(int weekday, MeetupSchedule schedule) {
    List<LocalDate> days = findDaysOfWeek(this.month, DayOfWeek.of(weekday));
    return matchSchedule(days, schedule);
  }

  private LocalDate matchSchedule(List<LocalDate> days, MeetupSchedule schedule) {
    switch (schedule) {
      case MeetupSchedule.FIRST:
        return days.get(0);
      case MeetupSchedule.SECOND:
        return matchingDays.get(1);
      case MeetupSchedule.THIRD:
        return matchingDays.get(2);
      case MeetupSchedule.FOURTH:
        return matchingDays.get(3);
      case MeetupSchedule.LAST:
        return matchingDays.get(matchingDays.size() - 1);
    }

    return null;
  }

  private List<LocalDate> findDaysOfWeek(YearMonth month, DayOfWeek dayOfWeek) {
    LocalDate firstDayOfMonth = LocalDate.of(month.getYear(), month.getMonth(), 1); 
    LocalDate lastDayOfMonth = LocalDate.of(month.getYear(), month.getMonth(), firstDayOfMonth.lengthOfMonth())
    List<LocalDate> matches = new ArrayList<> ();
    for (LocalDate day = firstDayOfMonth; !day.isAfter(lastDayOfMonth); day.plusDays(1)) {
      if (day.getDayOfWeek() == dayOfWeek) {
        matches.add(day);
      }
    }
    return matches;
  }
}

