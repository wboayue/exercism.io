from enum import Enum
from functools import partial

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

    for planet in Planet:
      method_name = "on_{}".format(planet.name.lower())
      setattr(self, method_name, partial(self.on, planet))

  def on(self, planet):
    return planet.space_age(self.seconds)
