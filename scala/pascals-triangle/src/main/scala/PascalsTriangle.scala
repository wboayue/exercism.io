object PascalsTriangle {

  def triangle(num: Int): List[List[Int]] = {
    require(num > 0, "rows must be greater than 0")
    Stream.iterate(List(1))(buildRow(_))
      .take(num).toList
  }

  private def buildRow(previous: List[Int]): List[Int] = {
    (0 :: previous ++ List(0))
      .sliding(2,1)
      .map(_.sum).toList
  }

}
