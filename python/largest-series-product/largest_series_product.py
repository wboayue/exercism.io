from functools import reduce
from operator import mul

def _chunks(digits, n):
  for i in range(len(digits) - n + 1):
    yield [int(x) for x in digits[i:i+n]]

def largest_product(digits, n):
  if not 0 <= n <= len(digits):
    raise ValueError('invalid span')

  return max(reduce(mul, chunk, 1) for chunk in _chunks(digits, n))
