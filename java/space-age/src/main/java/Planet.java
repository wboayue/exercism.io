import java.math.BigDecimal;

public enum Planet {

  MERCURY(0.2408467),
  VENUS(0.61519726),
  MARS(1.8808158),
  EARTH(1.0),
  JUPITER(11.862615),
  SATURN(29.447498),
  URANUS(84.016846),
  NEPTUNE(164.79132);

  private final double orbitalPeriod;
  private final double EARTH_ORBITAL_PERIOD = 31557600;

  Planet(double coefficient) {
    this.orbitalPeriod = EARTH_ORBITAL_PERIOD * coefficient;
  }

  public double yearsFor(long seconds) {
    return seconds / this.orbitalPeriod;
  }

}
