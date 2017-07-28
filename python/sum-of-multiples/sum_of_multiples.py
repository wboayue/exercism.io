def sum_of_multiples(up_to, factors):
  return sum(_multiples(up_to, factors))

def _multiples(up_to, factors):
  def is_multiple(num):
    return any(num % factor == 0 for factor in factors)

  return [num for num in range(up_to) if is_multiple(num)]

