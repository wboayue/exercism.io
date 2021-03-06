import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

  private String word;
  private String sorted;

  public Anagram(String word) {
    this.word = word;
    this.sorted = sort(word);
  }

  public List<String> match(List<String> words) {
    return words.stream()
      .filter(this::isAnagram)
      .collect(Collectors.toList());
  }

  private String sort(String word) {
    return word.toLowerCase().chars()
      .sorted()
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
  }

  private boolean isAnagram(String candidate) {
    return !this.word.equalsIgnoreCase(candidate) && this.sorted.equals(sort(candidate));
  }

}
