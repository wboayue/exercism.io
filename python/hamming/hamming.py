# -*- coding: utf-8 -*-

def distance(strand1, strand2):
  return sum([x != y for (x, y) in zip(strand1, strand2)])