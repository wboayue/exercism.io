import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Etl {
  public Map<String, Integer> transform(Map<Integer, List<String>> old) {
    Map<String, Integer> results = new LinkedHashMap();

    for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
      Integer letterValue = entry.getKey();

      entry.getValue().stream()
        .map(letter -> letter.toLowerCase())
        .forEach(letter -> results.put(letter, letterValue));
    }

    return results;
  }
}
