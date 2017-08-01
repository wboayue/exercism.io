from functools import reduce
from operator import mul

def _chunks(digits, n):
  for i in range(len(digits) - n + 1):
    yield [int(x) for x in digits[i:i+n]]

def largest_product(digits, n):
  if n < 0 or n > len(digits):
    raise ValueError('invalid span')

  if n == 0:
    return 1

  return max(reduce(mul, chunk) for chunk in _chunks(digits, n))
