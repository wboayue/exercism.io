class Luhn(object):
  def __init__(self, number):
    self._numbers = number.replace(' ', '')

  def is_valid(self):
    if not (len(self._numbers) > 1 and self._numbers.isdigit()):
      return False

    digits = list(map(int, self._numbers))

    for i in range(len(digits)-2, -1, -2):
      digits[i] = digits[i] * 2

      if digits[i] > 9:
        digits[i] = digits[i] - 9

    return sum(digits) % 10 == 0
