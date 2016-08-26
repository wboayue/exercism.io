import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

public class WordCount {

  private static final Pattern SPLIT_PATTERN = Pattern.compile("[^\\w\\d]+");

  public Map<String, Integer> phrase(String sentence) {
    Stream<String> words = SPLIT_PATTERN.splitAsStream(sentence.toLowerCase());

    return words.collect(
      Collectors.groupingBy(Function.identity(), Collectors.summingInt(word -> 1))
    );
  }

}
