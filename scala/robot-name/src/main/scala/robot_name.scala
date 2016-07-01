class Robot {

  private val letters = new RandomBag('A' to 'Z')
  private val digits = new RandomBag(0 to 9)
  private var generatedName = generateRandomName

  def name(): String = generatedName

  def reset(): Unit = {
    generatedName = generateRandomName
  }

  def generateRandomName(): String = {
    letters.take(2).mkString ++ digits.take(3).mkString
  }

}

class RandomBag[T](items: IndexedSeq[T]) extends Iterator[T] {

  private val numbers = new scala.util.Random
  private val range = items.size  

  def randomIndex(): Int = numbers.nextInt(range)

  def next(): T = items(randomIndex)

  def hasNext(): Boolean = true
  
}
