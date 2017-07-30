from itertools import chain

def sum_of_multiples(up_to, factors):
  return sum(set(chain.from_iterable(range(x, up_to, x) for x in factors)))
