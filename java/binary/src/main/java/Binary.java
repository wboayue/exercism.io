public class Binary {

  private String number;
  
  public Binary(String number) {
    this.number = number;
  }

  public int getDecimal() {
    if (isValid()) {
      return this.number.chars()
        .map(Character::getNumericValue)
        .reduce(0, (sum, digit) -> sum * 2 + digit);
    } else {
      return 0;
    }
  }

  private boolean isValid() {
    return this.number.chars().allMatch(digit -> digit == '0' || digit == '1');
  }

}
