import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Acronym {

  private static final Pattern SPLIT_PATTERN = Pattern.compile("(\\W+|[a-z](?=[A-Z]))");

  public static String generate(String phrase) {
    return SPLIT_PATTERN
      .splitAsStream(phrase)
      .map(Acronym::extractSignificantLetter)
      .collect(Collectors.joining(""));
  }

  private static final String extractSignificantLetter(String word) {
    return word.toUpperCase().substring(0, 1);
  }

}
