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
      .mapToObj(i -> shift(plain.charAt(i), key.charAt(i)))
      .collect(Collectors.joining());
  }

  private String shift(char plain, char key) {
    int cipher = (plain + (key - 'a'));
    if (cipher > 'z') {
      cipher -= 26;
    }
    return String.valueOf((char)cipher);
  }

  public String decode(String cipher) {
    return IntStream.range(0, cipher.length())
      .mapToObj(i -> unshift(cipher.charAt(i), key.charAt(i)))
      .collect(Collectors.joining());
  }

  private String unshift(char cipher, char key) {
    int plain = (cipher - (key - 'a'));
    if (plain < 'a') {
      plain += 26;
    }
    return String.valueOf((char)plain);
  }

  public String getKey() {
    return this.key;
  }

}