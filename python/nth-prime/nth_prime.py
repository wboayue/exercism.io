def nth_prime(n):
  if n == 0:
    raise ValueError

  i, candidate, primes,  = 1, 2, []

  while True:
    if _is_prime(primes, candidate):
      if i == n:
        return candidate

      i += 1
      primes.append(candidate)

    candidate += 1

def _is_prime(primes, x):
  return all(x % prime != 0 for prime in primes)
