import java.util.Arrays;
import java.util.List;

public class Pangrams {

  private static List<String> ALPHABETS = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

  public static boolean isPangram(String setence) {
    String normalized = setence.toLowerCase();
    return ALPHABETS.stream().allMatch(letter -> normalized.contains(letter));
  }

}