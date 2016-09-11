public class Hexadecimal {

  public static int toDecimal(String number) {
    String upperNumber = number.toUpperCase();
    
    if (isValid(upperNumber)) {
      return upperNumber.chars()
        .map(Character::getNumericValue)
        .reduce(0, (sum, digit) -> sum * 16 + digit);
    } else {
      return 0;
    }
  }

  private static boolean isValid(String number) {
    return number.chars().allMatch(Hexadecimal::isValidDigit);
  }

  private static boolean isValidDigit(int codePoint) {
    return (codePoint >= '0' && codePoint <= '9') ||
      (codePoint >= 'A' && codePoint <= 'F');
  }

}
