import scala.annotation.tailrec

class Robot {

  private var generatedName = Robot.nextUniqueName

  def name(): String = generatedName

  def reset(): Unit = {
    generatedName = Robot.nextUniqueName
  }

}

object Robot {

  private var usedNames = scala.collection.mutable.Set.empty
  private val names: Stream[String] = RandomNames().stream
  
  def nextUniqueName(): String = {
    names.take(1).mkString
  }

}

case class RandomNames() {

  private val letters = new RandomBag('A' to 'Z').stream
  private val digits = new RandomBag(0 to 9).stream

  def generateName(): String = {
    letters.take(2).mkString ++ digits.take(3).mkString
  }

  def stream: Stream[String] = {
    Stream.continually(generateName)
  }

}

class RandomBag[T](items: IndexedSeq[T]) {

  private val numbers = new scala.util.Random
  private val range = items.size  

  def randomIndex = numbers.nextInt(range)

  def stream: Stream[T] = {
    Stream.continually(items(randomIndex))
  }
  
}
