public class SumOfMultiples {

  public static int sum(int number, int[] multipliers) {
    int sum = 0;
    for (int i = 1; i < number; ++i) {
      if (isMultiple(i, multipliers)) {
        sum += i;
      }
    }
    return sum;
  }

  public static boolean isMultiple(int number, int[] multipliers) {
    for (int i = 0; i < multipliers.length; ++i) {
      if (number % multipliers[i] == 0) {
        return true;
      }
    }
    return false;
  }

}
