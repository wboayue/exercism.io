import scala.collection.SortedMap

object Raindrops {

  def apply() = this

  val Drops = SortedMap(
    (3 -> "Pling"),
    (5 -> "Plang"),
    (7 -> "Plong")
  )

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

  implicit class RaindropsUtils(val factor: Int) {
    def isFactorOf(number: Int): Boolean = number % factor == 0
  }

}