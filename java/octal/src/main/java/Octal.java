public class Octal {

  private String number;

  public Octal(String number) {
    this.number = number;
  }

  public int getDecimal() {
    if (isNotValid()) {
      return 0;
    }

    return this.number.chars()
      .map(Character::getNumericValue)
      .reduce(0, (sum, digit) -> sum * 8 + digit);
  }

  private boolean isNotValid() {
    return this.number.chars().anyMatch(digit -> digit < '0' || digit > '7');
  }

}
