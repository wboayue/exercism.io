from enum import Enum

BASE = 31557600 # base earth orbital period

class Planet(Enum):
  EARTH   = BASE
  MERCURY = BASE * 0.2408467
  VENUS   = BASE * 0.61519726
  MARS    = BASE * 1.8808158
  JUPITER = BASE * 11.862615
  SATURN  = BASE * 29.447498
  URANUS  = BASE * 84.016846
  NEPTUNE = BASE * 164.79132

  def __init__(self, orbital_period):
    self.orbital_period = orbital_period

  def space_age(self, seconds):
    return round(seconds / self.orbital_period, 2)

class SpaceAge(object):
  def __init__(self, seconds):
    self.seconds = seconds

  def on(self, planet):
    return planet.space_age(self.seconds)

  def on_earth(self):
    return self.on(Planet.EARTH)

  def on_mercury(self):
    return self.on(Planet.MERCURY)

  def on_venus(self):
    return self.on(Planet.VENUS)

  def on_mars(self):
    return self.on(Planet.MARS)

  def on_jupiter(self):
    return self.on(Planet.JUPITER)

  def on_saturn(self):
    return self.on(Planet.SATURN)

  def on_uranus(self):
    return self.on(Planet.URANUS)

  def on_neptune(self):
    return self.on(Planet.NEPTUNE)
