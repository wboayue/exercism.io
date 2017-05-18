import java.util.stream.IntStream;

public final class Difference {

  public static int square(int x) {
    return x * x;
  }
    
  public static int computeSquareOfSumTo(int limit) {
    return square(IntStream.rangeClosed(1, limit).sum());
  }

  public static int computeSumOfSquaresTo(int limit) {
    return IntStream.rangeClosed(1, limit).map(Difference::square).sum();
  }

  public static int betweenSquareOfSumAndSumOfSquaresTo(int limit) {
    return computeSquareOfSumTo(limit) - computeSumOfSquaresTo(limit);
  }

}
