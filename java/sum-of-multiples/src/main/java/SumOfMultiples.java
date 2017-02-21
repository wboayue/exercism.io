public class SumOfMultiples {

  public static int sum(int number, int[] multiples) {
    int sum = 0;
    for (int i = 1; i < number; ++i) {
      if (isMultiple(i, multiples)) {
        sum += i;
      }
    }
    return sum;
  }

  public static boolean isMultiple(int number, int[] multiples) {
    for (int i = 0; i < multiples.length; ++i) {
      if (number % multiples[i] == 0) {
        return true;
      }
    }
    return false;
  }

}
