import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalsTriangle {

  public static int[][] computeTriangle(int rows) {
    if (rows < 0) throw new IllegalArgumentException();

    return IntStream.range(0, rows)
      .mapToObj(PascalsTriangle::buildRow)
      .toArray(int[][]::new);
  }

  public static boolean isTriangle(final int[][] triangle) {
    return IntStream.range(0, triangle.length)
      .allMatch(row -> isValidRow(row, triangle[row]));
  }

  public static int[] buildRow(int row) {
    return IntStream.rangeClosed(0, row)
      .map(col -> valueAt(row, col))
      .toArray();
  }

  public static boolean isValidRow(int rowNum, int[] row) {
    return IntStream.rangeClosed(0, rowNum)
      .allMatch(col -> row[col] == valueAt(rowNum, col));
  }

  private static int valueAt(int row, int col) {
    return factorial(row) / (factorial(col) * factorial(row - col));
  }

  private static int factorial(int n) {
    return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
  }

}