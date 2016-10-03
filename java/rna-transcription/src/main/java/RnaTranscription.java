import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RnaTranscription {

  public static String ofDna(String strand) {
    assertValid(strand);

    return strand.chars()
      .mapToObj(RnaTranscription::toRna)
      .collect(Collectors.joining());
  }

  private static final Map<Character, String> DNA_TO_RNA = new TreeMap<>();
  static {
    DNA_TO_RNA.put('G', "C");
    DNA_TO_RNA.put('C', "G");
    DNA_TO_RNA.put('T', "A");
    DNA_TO_RNA.put('A', "U");
  }

  public static String toRna(int nucleotide) {
    return DNA_TO_RNA.get((char)nucleotide);
  }

  public static void assertValid(String strand) {
    if (strand.chars().anyMatch(nucleotide -> !DNA_TO_RNA.containsKey((char)nucleotide))) {
      throw new IllegalArgumentException("Invalid strand");
    }
  }

}