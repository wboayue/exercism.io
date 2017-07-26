from enum import Enum

def sieve(up_to):
  if up_to < 2:
    return []

  return [x for x in _generate_primes(up_to)]

class NumberType(Enum):
  PRIME = 1
  COMPOSITE = 2

def _generate_primes(up_to):
  candidates = [NumberType.PRIME] * (up_to+1)

  for i in range(2, up_to+1):
    if candidates[i] == NumberType.COMPOSITE:
      continue

    _mark_non_primes(candidates, i, up_to)

    yield i

def _mark_non_primes(candidates, prime, up_to):
  for i in range(prime, up_to+1, prime):
    candidates[i] = NumberType.COMPOSITE
