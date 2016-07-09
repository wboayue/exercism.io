object Squares {

  def apply() = this

  def squareOfSums(n: Int): Double = {
    math.pow((n * (n + 1) / 2), 2)
  }

  def sumOfSquares(n: Int): Double = {
    (2 * math.pow(n, 3) + 3 * math.pow(n, 2) + n) / 6
  }

  def difference(n: Int): Double = {
    squareOfSums(n) - sumOfSquares(n)
  }

}