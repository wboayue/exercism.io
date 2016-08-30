import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

  private static long GIGASECOND = 1000000000;
  private LocalDateTime date;

  public Gigasecond(LocalDate origin) {
    this(origin.atStartOfDay());
  }

  public Gigasecond(LocalDateTime origin) {
    this.date = origin.plusSeconds(GIGASECOND);
  }

  public LocalDateTime getDate() {
    return this.date;
  }

}