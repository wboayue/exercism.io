import scala.math.BigDecimal.RoundingMode

class SpaceAge(val seconds: BigDecimal) {
  import SpaceAge.SpaceAgeBigDecimal
  import Planet._

  lazy val onEarth = seconds toYearsOn Earth
  lazy val onMercury = seconds toYearsOn Mercury
  lazy val onVenus = seconds toYearsOn Venus
  lazy val onMars = seconds toYearsOn Mars
  lazy val onJupiter = seconds toYearsOn Jupiter
  lazy val onSaturn = seconds toYearsOn Saturn
  lazy val onUranus = seconds toYearsOn Uranus
  lazy val onNeptune = seconds toYearsOn Neptune
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
    def toYearsOn(planet: Planet): BigDecimal = {
      (seconds / planet.orbitalPeriod).setScale(2, RoundingMode.HALF_UP)
    }
  }
}
