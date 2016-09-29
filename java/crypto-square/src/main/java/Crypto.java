import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Crypto {

  private String plainText;
  private String normalizedPlaintext;

  public Crypto(String plainText) {
    this.normalizedPlaintext = plainText.toLowerCase().replaceAll("[^\\w\\d]", "");
  }

  public String getNormalizedPlaintext() {
    return this.normalizedPlaintext;
  }

  public int getSquareSize() {
    return (int) Math.ceil(Math.sqrt(this.normalizedPlaintext.length()));
  }

  public int getColSize() {
    return (int) Math.ceil((double)this.normalizedPlaintext.length() / getSquareSize());
  }

  public List<String> getPlaintextSegments() {
    List<String> segments = new ArrayList<>();
    for (int i = 0; i < this.normalizedPlaintext.length(); i += getSquareSize()) {
      segments.add(this.normalizedPlaintext.substring(i, Math.min(i + getSquareSize(), this.normalizedPlaintext.length())));
    }
    return segments;
  }

  public String getCipherText() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < getSquareSize(); ++i) {
      for (String segment : getPlaintextSegments()) {
        if (i < segment.length()) {
          result.append(segment.charAt(i));
        }
      }
    }
    return result.toString();
  }

  public String getNormalizedCipherText() {
    StringBuilder result = new StringBuilder();
    String cipherText = getCipherText();
    for (int i = 0; i < cipherText.length(); ++i) {
      if (i != 0 && i % getColSize() == 0) {
        result.append(" ");
      }
      result.append(cipherText.charAt(i));
    }
    return result.toString();
  }

}