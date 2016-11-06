object SumOfMultiples {

  def sumOfMultiples(multiples: List[Int], num: Int): Int = {
    def isMultiple(x: Int) = multiples.exists(x % _ == 0) 
    List.range(1, num).filter(isMultiple).sum
  }

}