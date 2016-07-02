import scala.annotation.tailrec

class Robot {

  private var generatedName = Robot.nextName

  def name(): String = generatedName

  def reset(): Unit = {
    generatedName = Robot.nextName
  }

}

object Robot {

  private val names = new UniqueFilter(new RandomNames())
  
  def nextName(): String = {
    names.next
  }

}

class UniqueFilter(stream: Iterator[String]) extends Iterator[String] {

  private var used: Set[String] = Set.empty

  @tailrec
  def next(): String = {
    val item = stream.next

    if (used.contains(item)) {
      next()
    } 

    used += item
    item   
  }

  def hasNext(): Boolean = true

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

  def next(): T = items(randomIndex)

  def randomIndex(): Int = numbers.nextInt(range)

  def hasNext(): Boolean = true
  
}
