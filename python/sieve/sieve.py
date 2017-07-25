def sieve(n):
  if n < 2:
    return []

  primes = [2]

  for x in range(2, n+1):
    if _is_prime(primes, x):
      primes.append(x)

  return primes

def _is_prime(primes, x):
  for y in primes:
    if x % y == 0:
      return False
          
  return True
