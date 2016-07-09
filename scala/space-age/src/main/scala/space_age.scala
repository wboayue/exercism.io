import scala.math.BigDecimal.RoundingMode

class SpaceAge(val seconds: BigDecimal) {

  lazy val onEarth = SpaceAge.convert(seconds)
  lazy val onMercury = SpaceAge.convert(seconds, earthRatio = 0.2408467)
  lazy val onVenus = SpaceAge.convert(seconds, earthRatio = 0.61519726)
  lazy val onMars = SpaceAge.convert(seconds, earthRatio = 1.8808158)
  lazy val onJupiter = SpaceAge.convert(seconds, earthRatio = 11.862615)
  lazy val onSaturn = SpaceAge.convert(seconds, earthRatio = 29.447498)
  lazy val onUranus = SpaceAge.convert(seconds, earthRatio = 84.016846)
  lazy val onNeptune = SpaceAge.convert(seconds, earthRatio = 164.79132)

}

object SpaceAge {

  def apply(seconds: Double) = new SpaceAge(seconds)

  val EarthYear: BigDecimal = 31557600

  def convert(seconds: BigDecimal, earthRatio: BigDecimal = 1): BigDecimal = {
    (seconds / (EarthYear * earthRatio)).setScale(2, RoundingMode.HALF_UP)
  }
}
