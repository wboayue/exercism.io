object SumOfMultiples {

  def sumOfMultiples(multiples: List[Int], num: Int): Int = {
    val uniqueMultiples = multiples.flatMap(mutiple => List.range(mutiple, num, mutiple)).toSet
    uniqueMultiples.sum
  }

}