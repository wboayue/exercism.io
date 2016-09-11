import java.util.function.Function;

public class Octal {

  private String number;
  private Converter converter = new Converter(8);

  public Octal(String number) {
    this.number = number;
  }

  public int getDecimal() {
    return this.converter.apply(this.number);
  }

  private static class Converter implements Function<String, Integer> {
    
    private int base;

    public Converter(int base) {
      this.base = base;
    }

    public Integer apply(String number) {
      if (isNotValid(number)) {
        return 0;
      }

      final int base = this.base;

      return number.chars()
        .map(Character::getNumericValue)
        .reduce(0, (sum, digit) -> sum * base + digit);
    }

    private boolean isNotValid(String number) {
      return number.chars().anyMatch(digit -> digit < '0' || digit > ('0' + base -1));
    }

  }

}
