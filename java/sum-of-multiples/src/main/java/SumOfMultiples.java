import java.util.stream.IntStream;

public class SumOfMultiples {

  public static int sum(final int number, final int[] factors) {
    return IntStream.range(1, number)
              .filter(x -> isMultiple(x, factors))
              .sum();
  }

  public static boolean isMultiple(final int number, final int[] factors) {
    return IntStream.of(factors).anyMatch(x -> number % x == 0);
  }

}
