ARABIC_TO_ROMAN = [
  (1000, 'M'),
  (900, 'CM'),
  (500, 'D'),
  (400, 'CD'),
  (100, 'C'),
  (90, 'XC'),
  (50, 'L'),
  (40, 'XL'),
  (10, 'X'),
  (9, 'IX'),
  (5, 'V'),
  (4, 'IV'),
  (1, 'I')
]

def numeral(number):
  roman = []

  for factor, numeral in ARABIC_TO_ROMAN:
    power, number = divmod(number, factor)

    if power:
      roman.append(numeral * power)

  return ''.join(roman)
