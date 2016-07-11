import scala.math.BigDecimal.RoundingMode

class SpaceAge(val seconds: BigDecimal) {

  lazy val onEarth = SpaceAge.ageOn(seconds, Planet.Earth)
  lazy val onMercury = SpaceAge.ageOn(seconds, Planet.Mercury)
  lazy val onVenus = SpaceAge.ageOn(seconds, Planet.Venus)
  lazy val onMars = SpaceAge.ageOn(seconds, Planet.Mars)
  lazy val onJupiter = SpaceAge.ageOn(seconds, Planet.Jupiter)
  lazy val onSaturn = SpaceAge.ageOn(seconds, Planet.Saturn)
  lazy val onUranus = SpaceAge.ageOn(seconds, Planet.Uranus)
  lazy val onNeptune = SpaceAge.ageOn(seconds, Planet.Neptune)

}

sealed class Planet(coefficient: Double) {

  val orbitalPeriod: BigDecimal  = SpaceAge.EarthOrbitalPeriod * coefficient

}

object Planet {

  val Earth = new Planet(1.0)
  val Mercury = new Planet(0.2408467)
  val Venus = new Planet(0.61519726)
  val Mars = new Planet(1.8808158)
  val Jupiter = new Planet(11.862615)
  val Saturn = new Planet(29.447498)
  val Uranus = new Planet(84.016846)
  val Neptune = new Planet(164.79132)

}

object SpaceAge {

  val EarthOrbitalPeriod: BigDecimal = 31557600

  def apply(seconds: Double) = new SpaceAge(seconds)

  def ageOn(seconds: BigDecimal, planet: Planet): BigDecimal = {
    (seconds / planet.orbitalPeriod).setScale(2, RoundingMode.HALF_UP)
  }
}
