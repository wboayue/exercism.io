class Raindrops {

  import Raindrops.RaindropsUtils

  def convert(number: Int): String = {
    val melody = Raindrops.Drops
      .keys
      .filter(_.isFactorOf(number))
      .map(Raindrops.Drops(_))

    if (melody.isEmpty) {
      number.toString
    } else {
      melody.mkString
    }
  }

}

object Raindrops {

  def apply(): Raindrops = new Raindrops()

  val Drops: Map[Int, String] = Map(
    (3 -> "Pling"),
    (5 -> "Plang"),
    (7 -> "Plong")
  )

  implicit class RaindropsUtils(val factor: Int) {
    def isFactorOf(number: Int): Boolean = number % factor == 0
  }

}