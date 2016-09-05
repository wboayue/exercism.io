import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Raindrops {

  private static Map<Integer, String> DROPS = new LinkedHashMap<>();
  static {
    DROPS.put(3, "Pling");
    DROPS.put(5, "Plang");
    DROPS.put(7, "Plong");
  }

  public static String convert(int number) {
    String sound = DROPS.entrySet().stream()
      .filter(entry -> number % entry.getKey() == 0)
      .map(entry -> entry.getValue())
      .collect(Collectors.joining());

    if (sound.isEmpty()) {
      return String.valueOf(number);
    } else {
      return sound;
    }
  }
}