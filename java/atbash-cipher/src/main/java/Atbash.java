public class Atbash {
  
  public static String encode(String plain) {
    return rotate(plain);
  }

  public static String decode(String cipher) {
    return rotate(cipher);
  }

  private static String rotate(String text) {
    int[] rotated = strip(text).chars()
      .map(Atbash::rotate)
      .toArray();

    return new String(rotated, 0, rotated.length);
  }

  private static String strip(String plain) {
    return plain.toLowerCase().replaceAll("[^a-z0-9]", "");
  }

  private static int A = Character.codePointAt(new char[] {'a'}, 0);
  private static int Z = Character.codePointAt(new char[] {'z'}, 0);

  private static int rotate(int codePoint) {
    if (Character.isDigit(codePoint)) {
      return codePoint;
    } else {
      return Z - (codePoint - A);
    }
  }

}