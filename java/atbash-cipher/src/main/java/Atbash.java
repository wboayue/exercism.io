import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Atbash {
  
  public static String encode(String plain) {
    return format(rotate(plain));
  }

  public static String decode(String cipher) {
    return rotate(cipher);
  }

  private static int A = Character.codePointAt(new char[] {'a'}, 0);
  private static int Z = Character.codePointAt(new char[] {'z'}, 0);

  private static String rotate(String text) {
    return strip(text).chars()
      .map(Atbash::rotate)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
  }

  private static int rotate(int codePoint) {
    if (Character.isDigit(codePoint)) {
      return codePoint;
    } else {
      return Z - (codePoint - A);
    }
  }

  private static String strip(String plain) {
    return plain.toLowerCase().replaceAll("[^a-z0-9]", "");
  }

  private static String format(String cipher) {
    return String.join(" ", chunk(cipher, 5));
  }

  private static List<String> chunk(String text, int chunkSize) {
    List<String> chunks = new ArrayList<>();
    int len = text.length();
    for (int i = 0; i < len; i += chunkSize) {
      chunks.add(text.substring(i, Math.min(len, i + chunkSize)));
    }
    return chunks;
  }

}