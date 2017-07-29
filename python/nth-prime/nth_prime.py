from math import log

def nth_prime(n: int) -> int:
  if n == 0:
    raise ValueError

  return _generate_primes(_limit(n))[n-1]

def _limit(n: int) -> int:
  """Calculate upper bound for value of nth prime"""
  if n < 6:
    n = 6

  return int(n*log(n) + n*log(log(n)))

def _generate_primes(up_to: int) -> list:
  primes, candidates = list(), [False] * (up_to+1)

  for i in range(2, up_to+1):
    if candidates[i]:
      continue

    primes.append(i)
    _mark_composites(candidates, i, up_to)

  return primes

def _mark_composites(candidates: list, prime: int, up_to: int) -> None:
  for i in range(prime*2, up_to+1, prime):
    candidates[i] = True
