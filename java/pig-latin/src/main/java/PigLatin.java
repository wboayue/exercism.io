import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Pattern;

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

  static String[] CONSONANTS = {"sch", "thr", "ch", "qu", "th"};

  public static String rotate(String word) {
    for (String consonant : CONSONANTS) {
      if (word.startsWith(consonant)) {
        return word.substring(consonant.length()) + consonant;
      }
    }
    return word.substring(1) + word.charAt(0);
  }

}