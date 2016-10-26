def is_leap_year(year):
  return divisible_by(year, 400) or (divisible_by(year, 4) and not divisible_by(year, 100))

def divisible_by(numerator, denominator):
  return numerator % denominator == 0
