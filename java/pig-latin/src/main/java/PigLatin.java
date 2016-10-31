import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PigLatin {

  public static String translate(String phrase) {
    return splitAsStream(phrase)
      .map(PigLatin::translateWord)
      .collect(Collectors.joining(" "));
  }

  public static Stream<String> splitAsStream(String phrase) {
    return Pattern.compile("\\s").splitAsStream(phrase.toLowerCase());
  }

  public static String translateWord(String word) {
    if (beginsWithVowel(word)) {
      return word + "ay";
    } else {
      return rotate(word) + "ay";
    }
  }

  public static boolean beginsWithVowel(String word) {
    return Pattern.matches("^([aeiuo]|yt|xr).*", word);
  }

  static Pattern[] CONSONANT_PATTERNS = {
    Pattern.compile("^(sch).*"),
    Pattern.compile("^(thr).*"),
    Pattern.compile("^(\\w?qu).*"),
    Pattern.compile("^(ch).*"),
    Pattern.compile("^(th).*"),
    Pattern.compile("^(\\w).*"),
  };

  public static String rotate(String word) {
    for (Pattern pattern : CONSONANT_PATTERNS) {
      Matcher matcher = pattern.matcher(word);
      if (matcher.matches()) {
        String consonantSound = matcher.group(1);
        return word.substring(consonantSound.length()) + consonantSound;
      }
    }

    throw new IllegalArgumentException("don't know how to rotate: " + word);
  }

}