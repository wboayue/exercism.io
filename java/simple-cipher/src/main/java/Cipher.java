import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cipher {
  
  private String key;

  public Cipher() {
    this.key = generateKey();
  } 

  private String generateKey() {
    return new Random().ints(100, 'a', 'z' + 1)
      .mapToObj(c -> String.valueOf((char) c))
      .collect(Collectors.joining());
  }

  public Cipher(String key) {
    assertValidKey(key);
    this.key = key;
  }

  private void assertValidKey(String key) {
    if (key == null || key.isEmpty()) throw new IllegalArgumentException("empty key");
    if (!key.matches("[a-z]+")) throw new IllegalArgumentException("key may only contain lowercase letters");
  }

  public String encode(String plain) {
    return IntStream.range(0, plain.length())
      .mapToObj(i -> shift(plain.charAt(i), offset(key.charAt(i))))
      .collect(Collectors.joining());
  }

  private int offset(char key) {
    return key - 'a';
  }

  private String shift(char plain, int offset) {
    return wrapLetter(plain + offset);
  }

  private String wrapLetter(int letter) {
    if (letter > 'z') {
      letter -= 26;
    } else if (letter < 'a') {
      letter += 26;
    }
    return String.valueOf((char) letter);
  }

  public String decode(String cipher) {
    return IntStream.range(0, cipher.length())
      .mapToObj(i -> unshift(cipher.charAt(i), offset(key.charAt(i))))
      .collect(Collectors.joining());
  }

  private String unshift(char cipher, int offset) {
    return wrapLetter(cipher - offset);
  }

  public String getKey() {
    return this.key;
  }

}