import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class DNA {

  private Map<Character, Integer> nucleotides = new HashMap<>();

  public DNA(String strand) {
    this.nucleotides.putAll(DNA.parse(strand));
  }

  public Map<Character, Integer> nucleotideCounts() {
    return this.nucleotides;
  }

  public int count(char nucleotide) {
    if (!VALID_NUCLEOTIDES.contains(nucleotide)) {
      throw new IllegalArgumentException();
    }

    return this.nucleotides.get(nucleotide);
  }

  private static Map<Character, Integer> parse(String strand) {
    Map<Character, Integer> counts = new HashMap<>();
    counts.put('A', 0);
    counts.put('C', 0);
    counts.put('G', 0);
    counts.put('T', 0);

    for (char nucleotide : strand.toCharArray()) {
      counts.merge(nucleotide, 1, (old, step) -> old + step);
    }

    return counts;
  }

  private static Set<Character> VALID_NUCLEOTIDES = new HashSet<>();
  static {
    VALID_NUCLEOTIDES.add('A');
    VALID_NUCLEOTIDES.add('C');
    VALID_NUCLEOTIDES.add('G');
    VALID_NUCLEOTIDES.add('T');
  }

}
