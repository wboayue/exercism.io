object PascalsTriangle {

  def triangle(rows: Int): List[List[Int]] = {
    require(rows > 0, "rows must be greater than 0")
    (0 until rows).toList map buildRow
  }

  private def buildRow(row: Int): List[Int] = {
    (0 to row).toList map(cell(row, _))
  }

  private def cell(row: Int, col: Int): Int = {
    (factorial(row) / (factorial(col) * factorial(row - col))).toInt
  }

  private def factorial(n: Long): Long = {
    (1L to n).foldLeft(1L) ((x, y) => x * y)
  }

}
