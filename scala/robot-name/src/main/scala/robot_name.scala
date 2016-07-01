class Robot {

  private val names = new RandomNames()
  private var generatedName = names.next

  def name(): String = generatedName

  def reset(): Unit = {
    generatedName = names.next
  }
  
}

class RandomNames extends Iterator[String] {

  private val letters = new RandomBag('A' to 'Z')
  private val digits = new RandomBag(0 to 9)

  def next(): String = {
    letters.take(2).mkString ++ digits.take(3).mkString
  }

  def hasNext(): Boolean = true

}

class RandomBag[T](items: IndexedSeq[T]) extends Iterator[T] {

  private val numbers = new scala.util.Random
  private val range = items.size  

  def randomIndex(): Int = numbers.nextInt(range)

  def next(): T = items(randomIndex)

  def hasNext(): Boolean = true
  
}
