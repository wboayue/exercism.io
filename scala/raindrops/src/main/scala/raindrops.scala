import scala.collection.SortedMap

class Raindrops {

  import Raindrops.RaindropsUtils

  def convert(number: Int): String = {
    val melody = Raindrops.Drops
      .filterKeys(_.isFactorOf(number))
      .values

    if (melody.isEmpty) {
      number.toString
    } else {
      melody.mkString
    }
  }

}

object Raindrops {

  def apply(): Raindrops = new Raindrops()

  val Drops = SortedMap(
    (3 -> "Pling"),
    (5 -> "Plang"),
    (7 -> "Plong")
  )

  implicit class RaindropsUtils(val factor: Int) {
    def isFactorOf(number: Int): Boolean = number % factor == 0
  }

}