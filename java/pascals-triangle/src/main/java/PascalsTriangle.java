public class PascalsTriangle {

  public static int[][] computeTriangle(int rows) {
    if (rows < 0) {
      throw new IllegalArgumentException();
    }

    int[][] triangle = buildTriangle(rows);

    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col <= row; ++col) {
        triangle[row][col] = valueAt(row, col);
      }
    }

    return triangle;
  }

  public static boolean isTriangle(int[][] triangle) {

    for (int row = 0; row < triangle.length; ++row) {
      for (int col = 0; col <= row; ++col) {
        if (triangle[row][col] != valueAt(row, col)) {
          return false;
        };
      }
    }

    return true;
  }

  private static int[][] buildTriangle(int rows) {
    if (rows == 0) {
      return new int[][]{};
    }

    int[][] result = new int[rows][];
    for (int i = 0; i < rows; ++i) {
      result[i] = new int[i+1];
    }

    return result;
  }

  private static int valueAt(int row, int col) {
    return factorial(row) / (factorial(col) * factorial(row - col));
  }

  private static int factorial(int n) {
    if (n < 2) {
      return 1; 
    } else {
      return n * factorial(n - 1);
    }
  }

}