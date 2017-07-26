from enum import Enum

def sieve(up_to):
  if up_to < 2:
    return []

  return list(_generate_primes(up_to))

class NumberType(Enum):
  PRIME = 1
  COMPOSITE = 2

def _generate_primes(up_to):
  candidates = [NumberType.PRIME] * (up_to+1)

  for i in range(2, up_to+1):
    if candidates[i] == NumberType.COMPOSITE:
      continue

    _mark_composites(candidates, i, up_to)

    yield i

def _mark_composites(candidates, prime, up_to):
  for i in range(prime*2, up_to+1, prime):
    candidates[i] = NumberType.COMPOSITE
