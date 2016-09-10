import java.util.ArrayList;
import java.util.List;

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
    int[] rotated = strip(text).chars()
      .map(Atbash::rotate)
      .toArray();

    return new String(rotated, 0, rotated.length);
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

  private static final int CHUNK_SIZE = 5;

  private static String format(String cipher) {
    StringBuffer formatted = new StringBuffer();
    int len = cipher.length();
    for (int i = 0; i < len; i += CHUNK_SIZE) {
      if (i != 0) {
        formatted.append(" ");
      }
      formatted.append(cipher.substring(i, Math.min(len, i + CHUNK_SIZE)));
    }
    return formatted.toString();
  }

}