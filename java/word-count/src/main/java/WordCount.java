import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

public class WordCount {

  public Map<String, Integer> phrase(String sentence) {
    Stream<String> words = Pattern.compile("[^\\w\\d]+").splitAsStream(sentence.toLowerCase());

    return words.collect(
      Collectors.groupingBy(Function.identity(), Collectors.summingInt(word -> 1))
    );
  }

}
