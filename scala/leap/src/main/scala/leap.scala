class Year(year: Int) {

  implicit class IntUtils(val i: Int) {
    def isDivisibleBy(factor: Int): Boolean = i % factor == 0 
  }

  def isLeap: Boolean = year match {
    case year if year isDivisibleBy 400 => true
    case year if year isDivisibleBy 100 => false
    case year if year isDivisibleBy 4 => true
    case _ => false
  }

}

object Year {
  def apply(year: Int): Year = {
    new Year(year)
  }
}
