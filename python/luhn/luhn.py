class Luhn(object):
  def __init__(self, number):
    self._numbers = [ch for ch in number if not ch.isspace()]

  def is_valid(self):
    if not (len(self._numbers) > 1 and all(c.isdigit() for c in self._numbers)):
      return False

    digits = map(int, self._numbers)
  
    for i in range(len(digits)-2, -1, -2):
      digits[i] = digits[i] * 2

      if digits[i] > 9:
        digits[i] = digits[i] - 9

    return sum(digits) % 10 == 0
