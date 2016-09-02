import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Scrabble {

  private String phrase;
  private static final Map<Integer, Integer> scores = buildScoreMap();

  public Scrabble(String phrase) {
    this.phrase = phrase == null ? "" : phrase;
  }

  public int getScore() {
    return this.phrase.chars()
      .map(this::scoreLetter)
      .sum();
  }

  private int scoreLetter(int codePoint) {
    return Scrabble.scores.getOrDefault(Character.toUpperCase(codePoint), 0);
  }

  private static Map<Integer, Integer> buildScoreMap() {
    Map<Integer, Integer> scores = new TreeMap<>();
    addLetters(scores, "AEIOULNRST", 1);
    addLetters(scores, "DG", 2);
    addLetters(scores, "BCMP", 3);
    addLetters(scores, "FHVWY", 4);
    addLetters(scores, "K", 5);
    addLetters(scores, "JX", 8);
    addLetters(scores, "QZ", 10);
    return scores;
  }

  private static void addLetters(Map<Integer, Integer> scores, String letters, int score) {
    letters.chars().forEach(letter -> scores.put(letter, score));
  }

}