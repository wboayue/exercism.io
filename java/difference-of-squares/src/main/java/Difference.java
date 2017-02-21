import java.util.stream.IntStream;

public final class Difference {
    
  public static int computeSquareOfSumTo(int limit) {
    int x = IntStream.rangeClosed(1, limit).sum();
    return x * x;
  }

  public static int computeSumOfSquaresTo(int limit) {
    return IntStream.rangeClosed(1, limit)
              .map(x -> x * x)
              .sum();
  }

  public static int betweenSquareOfSumAndSumOfSquaresTo(int limit) {
    return computeSquareOfSumTo(limit) - computeSumOfSquaresTo(limit);
  }

}
