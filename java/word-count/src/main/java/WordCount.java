import java.util.Map;
import java.util.HashMap;

public class WordCount {

  public Map<String, Integer> phrase(String sentence) {
    Map<String, Integer> counts = new HashMap<> ();

    String[] words = sentence.toLowerCase().split("[^\\w-]+");

    for (String word : words) {
      counts.merge(word, 1, (count, step) -> count + step);
    }

    return counts;
  }

}
