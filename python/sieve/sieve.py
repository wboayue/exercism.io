def sieve(up_to):
  if up_to < 2:
    return []

  return [x for x in _generate_primes(up_to)]

def _generate_primes(up_to):
  candidates = [True] * (up_to+1)

  for i in range(2, up_to+1):
    if not candidates[i]:
      continue

    _mark_non_primes(candidates, i, up_to)

    yield i

def _mark_non_primes(candidates, prime, up_to):
  for i in range(prime, up_to+1, prime):
    candidates[i] = False
