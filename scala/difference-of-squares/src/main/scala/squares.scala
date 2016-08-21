object Squares {

  def apply() = this

  def squareOfSums(n: Int) = {
    math.pow((n * (n + 1) / 2), 2)
  }

  def sumOfSquares(n: Int) = {
    (2 * math.pow(n, 3) + 3 * math.pow(n, 2) + n) / 6
  }

  def difference(n: Int) = {
    squareOfSums(n) - sumOfSquares(n)
  }

}