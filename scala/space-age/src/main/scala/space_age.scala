import scala.math.BigDecimal.RoundingMode

class SpaceAge(val seconds: BigDecimal) {
  import SpaceAge.SpaceAgeBigDecimal

  lazy val onEarth = seconds.toYears(Planet.Earth)
  lazy val onMercury = seconds.toYears(Planet.Mercury)
  lazy val onVenus = seconds.toYears(Planet.Venus)
  lazy val onMars = seconds.toYears(Planet.Mars)
  lazy val onJupiter = seconds.toYears(Planet.Jupiter)
  lazy val onSaturn = seconds.toYears(Planet.Saturn)
  lazy val onUranus = seconds.toYears(Planet.Uranus)
  lazy val onNeptune = seconds.toYears(Planet.Neptune)
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

  implicit class SpaceAgeBigDecimal(seconds: BigDecimal) {
    def toYears(planet: Planet): BigDecimal = {
      (seconds / planet.orbitalPeriod).setScale(2, RoundingMode.HALF_UP)
    }
  }
}
