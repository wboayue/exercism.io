import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Luhn {

  private int[] digits;

  public Luhn(long number) {
    this.digits = String.valueOf(number).chars().map(d -> d - '0').toArray();
  }

  public int getCheckDigit() {
    return this.digits[this.digits.length - 1];
  }

  public int[] getAddends() {
    int[] addends = new int[this.digits.length];
    for (int i = addends.length - 1, j = 0; i >= 0; --i, ++j) {
      addends[i] = j % 2 == 0 ?  this.digits[i] : this.digits[i] * 2;
      if (addends[i] > 9) {
        addends[i] = addends[i] - 9;
      }
    }
    return addends;
  }

  public int getCheckSum() {
    return IntStream.of(getAddends()).sum();
  }

  public boolean isValid() {
    return getCheckSum() % 10 == 0;
  }

  public static long create(long number) {
    Luhn luhn = new Luhn(number * 10);
    int diff = luhn.getCheckSum() % 10;
    return number * 10 + ((10 - diff) % 10);
  }

}