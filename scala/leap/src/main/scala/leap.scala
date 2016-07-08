class Year(year: Int) {

  implicit class IntHelpers(val i: Int) {
    def isDivisibleBy(factor: Int): Boolean = i % factor == 0
  }

  def isLeap: Boolean = {
    year.isDivisibleBy(400) ||
      (year.isDivisibleBy(4) && !year.isDivisibleBy(100))
  }

}

object Year {
  def apply(year: Int): Year = {
    new Year(year)
  }
}
