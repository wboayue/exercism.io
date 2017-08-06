import string

class Luhn(object):
  def __init__(self, number):
    self._numbers = [ch for ch in number if not ch.isspace()]

  def is_valid(self):
    if len(self._numbers) < 2 or not all(c in string.digits for c in self._numbers):
      return False

    digits = [int(num) for num in self._numbers]
    digits = _double_second_digits(digits)

    return sum(digits) % 10 == 0

def _double_second_digits(digits):
  digits = list(digits)

  for i in range(len(digits) -2, -1, -2):
    digits[i] = digits[i] * 2

    if digits[i] > 9:
      digits[i] = digits[i] - 9

  return digits
