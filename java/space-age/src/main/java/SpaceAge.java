public class SpaceAge {
  
  private long seconds;

  public SpaceAge(long seconds) {
    this.seconds = seconds;
  }

  public long getSeconds() {
    return this.seconds;
  }

  public double onMercury() {
    return Planet.MERCURY.yearsFor(this.seconds);
  }

  public double onVenus() {
    return Planet.VENUS.yearsFor(this.seconds);
  }

  public double onMars() {
    return Planet.MARS.yearsFor(this.seconds);
  }

  public double onEarth() {
    return Planet.EARTH.yearsFor(this.seconds);
  }

  public double onJupiter() {
    return Planet.JUPITER.yearsFor(this.seconds);
  }

  public double onSaturn() {
    return Planet.SATURN.yearsFor(this.seconds);
  }

  public double onUranus() {
    return Planet.URANUS.yearsFor(this.seconds);
  }

  public double onNeptune() {
    return Planet.NEPTUNE.yearsFor(this.seconds);
  }

}
