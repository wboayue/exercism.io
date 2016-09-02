public class Binary {

  private String number;
  
  public Binary(String number) {
    this.number = number;
  }

  public int getDecimal() {
    if (isValid()) {
      int decimal = 0;

      for (char digit : this.number.toCharArray()) {
        decimal *= 2;

        if (digit == '1') {
          decimal += 1;
        }
      };

      return decimal;
    } else {
      return 0;
    }
  }

  private boolean isValid() {
    return this.number.chars().allMatch(digit -> digit == '0' || digit == '1');
  }

}
