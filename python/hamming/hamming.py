# -*- coding: utf-8 -*-

def distance(strand1, strand2):
  if len(strand1) != len(strand2):
    raise ValueError('strands must be equals lengths')

  return sum(x != y for x, y in zip(strand1, strand2))
