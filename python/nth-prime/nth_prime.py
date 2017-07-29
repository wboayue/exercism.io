from math import log
from enum import Enum

def nth_prime(n):
  if n == 0:
    raise ValueError

  limit = _approximate_limit(n)

  return list(_generate_primes(limit))[n-1]

def _approximate_limit(n):
  if n < 6:
    n = 6

  return int(n*log(n) + n*log(log(n)))

def _generate_primes(up_to):
  candidates = [False] * (up_to+1)

  for i in range(2, up_to+1):
    if candidates[i]:
      continue

    _mark_composites(candidates, i, up_to)

    yield i

def _mark_composites(candidates, prime, up_to):
  for i in range(prime*2, up_to+1, prime):
    candidates[i] = True
