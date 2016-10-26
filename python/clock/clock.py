# -*- coding: utf-8 -*-

class Clock:

  def __init__(self, hours, minutes):
    self.minutes = minutes % 60
    self.hours = (hours + (minutes // 60)) % 24

  def __str__(self):
    return u"{:02d}:{:02d}".format(self.hours, self.minutes)

  def __eq__(self, other):
    return (isinstance(other, self.__class__)
      and self.hours == other.hours
      and self.minutes == other.minutes)

  def __ne__(self, other):
    return not self.__eq__(other)

  def add(self, minutes):
    return Clock(self.hours, self.minutes + minutes)
