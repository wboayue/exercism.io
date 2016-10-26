import java.util.ArrayList;
import java.util.List;

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

  public List<String> getPlaintextSegments() {
    List<String> segments = new ArrayList<>();

    for (int i = 0; i < this.normalizedPlaintext.length(); i += getSquareSize()) {
      segments.add(this.normalizedPlaintext.substring(i, Math.min(i + getSquareSize(), this.normalizedPlaintext.length())));
    }

    return segments;
  }

  public String getCipherText() {
    return generateCipherText(CipherFlag.FLAT);
  }

  public String getNormalizedCipherText() {
    return generateCipherText(CipherFlag.NORMALIZED);
  }

  private String generateCipherText(CipherFlag flag) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < getSquareSize(); ++i) {
      if (i != 0 && CipherFlag.NORMALIZED == flag) {
        result.append(" ");
      }

      for (String segment : getPlaintextSegments()) {
        if (i < segment.length()) {
          result.append(segment.charAt(i));
        }
      }
    }

    return result.toString();
  }

  public static enum CipherFlag {
    NORMALIZED, FLAT
  }
}