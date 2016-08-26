import java.util.stream.IntStream;

public class Hamming {

  public static int compute(String strand1, String strand2) {
    if (strand1.length() != strand2.length()) {
      throw new IllegalArgumentException("stands not equals");
    }

    return (int) IntStream.range(0, strand1.length())
      .filter(i -> strand1.charAt(i) != strand2.charAt(i))
      .count();
  }

}
