import scala.math.BigDecimal.RoundingMode

class SpaceAge(val seconds: BigDecimal) {

  lazy val onEarth = SpaceAge.convertTo(Planets.Earth, seconds)
  lazy val onMercury = SpaceAge.convertTo(Planets.Mercury, seconds)
  lazy val onVenus =  SpaceAge.convertTo(Planets.Venus, seconds)
  lazy val onMars =  SpaceAge.convertTo(Planets.Mars, seconds)
  lazy val onJupiter =  SpaceAge.convertTo(Planets.Jupiter, seconds)
  lazy val onSaturn =  SpaceAge.convertTo(Planets.Saturn, seconds)
  lazy val onUranus =  SpaceAge.convertTo(Planets.Uranus, seconds)
  lazy val onNeptune = SpaceAge.convertTo(Planets.Neptune, seconds)

}

object SpaceAge {

  def apply(seconds: Double) = new SpaceAge(seconds)

  val EarthYear: BigDecimal = 31557600
  val SecondsInYear: Map[Planets.Value, BigDecimal] = Map(
    (Planets.Earth -> EarthYear),
    (Planets.Mercury -> EarthYear * 0.2408467),
    (Planets.Venus -> EarthYear * 0.61519726),
    (Planets.Mars -> EarthYear * 1.8808158),
    (Planets.Jupiter -> EarthYear * 11.862615),
    (Planets.Saturn -> EarthYear * 29.447498),
    (Planets.Uranus -> EarthYear * 84.016846),
    (Planets.Neptune -> EarthYear * 164.79132)
  )

  def convertTo(planet: Planets.Value, seconds: BigDecimal): BigDecimal = {
    (seconds / SpaceAge.SecondsInYear(planet)).setScale(2, RoundingMode.HALF_UP)
  }
}

object Planets extends Enumeration {
  val Earth, Mercury, Venus, Mars, Jupiter, Saturn, Uranus, Neptune = Value
}
