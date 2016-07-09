object Squares {

  def apply() = this

  def squareOfSums(n: Int): Double = {
    Math.pow((n * (n + 1) / 2), 2)
  }

  def sumOfSquares(n: Int): Double = {
    (2 * Math.pow(n, 3) + 3 * Math.pow(n, 2) + n) / 6
  }

  def difference(n: Int): Double = {
    squareOfSums(n) - sumOfSquares(n)
  }

}