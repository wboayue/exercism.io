import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Meetup {

  private int year;
  private int month;

  public Meetup(int month, int year) {
    this.month = month;
    this.year = year;
  }

  public DateTime day(int weekday, MeetupSchedule schedule) {
    List<LocalDate> days = Meetup.findDays(this.year, this.month, DayOfWeek.of(weekday));
    LocalDate day = matchSchedule(days, schedule);
    return new DateTime(day.getYear(), day.getMonthValue(), day.getDayOfMonth(), 0, 0);
  }

  private LocalDate matchSchedule(List<LocalDate> days, MeetupSchedule schedule) {
    switch (schedule) {
      case FIRST:
        return days.get(0);
      case SECOND:
        return days.get(1);
      case THIRD:
        return days.get(2);
      case FOURTH:
        return days.get(3);
      case LAST:
        return days.get(days.size() - 1);
      case TEENTH:
        List<LocalDate> teenth = Meetup.findTeenth(days);
        if (teenth.isEmpty()) {
          throw new IllegalArgumentException(String.format("Teenth not found in: %s", days));
        }
        return teenth.get(0);
      default:
        throw new IllegalArgumentException(String.format("Unsupported option: %s", schedule));
    }
  }

  private static Stream<LocalDate> daysInMonth(int year, int month) {
    LocalDate firstDay = LocalDate.of(year, month, 1);
    LocalDate lastDay = LocalDate.of(year, month, firstDay.lengthOfMonth());

    List<LocalDate> matches = new ArrayList<> ();
    for (LocalDate day = firstDay; !day.isAfter(lastDay); day = day.plusDays(1)) {
      matches.add(day);
    }

    return matches.stream();
  }

  private static List<LocalDate> findDays(int year, int month, DayOfWeek dayOfWeek) {
    return Meetup.daysInMonth(year, month)
      .filter(day -> day.getDayOfWeek() == dayOfWeek)
      .collect(Collectors.toList());
  }

  private static List<LocalDate> findTeenth(List<LocalDate> days) {
    return days.stream()
      .filter(day -> day.getDayOfMonth() >= 13 && day.getDayOfMonth() <= 19)
      .collect(Collectors.toList());
  }

}

