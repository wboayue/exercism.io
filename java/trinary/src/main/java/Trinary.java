public class Trinary {

  public static int toDecimal(String number) {
    if (isValid(number)) {
      return number.chars()
        .map(Character::getNumericValue)
        .reduce(0, (sum, digit) -> sum * 3 + digit);
    } else {
      return 0;
    }
  }

  private static boolean isValid(String number) {
    return number.chars().allMatch(digit -> digit >= '0' && digit <= '2');
  }

}
