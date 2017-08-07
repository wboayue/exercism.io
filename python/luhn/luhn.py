import string

class Luhn(object):
  def __init__(self, number):
    self._numbers = [ch for ch in number if not ch.isspace()]
    self._all_digits = all(c in string.digits for c in self._numbers)

  def is_valid(self):
    if not (len(self._numbers) > 1 and self._all_digits):
      return False

    digits = [int(digit) for digit in self._numbers]
  
    for i in range(len(digits)-2, -1, -2):
      digits[i] = digits[i] * 2

      if digits[i] > 9:
        digits[i] = digits[i] - 9

    return sum(digits) % 10 == 0
