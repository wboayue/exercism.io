def is_leap_year(year):

  def divisible_by(x, y):
    return x % y == 0

  return divisible_by(year, 400) or (divisible_by(year, 4) and not divisible_by(year, 100))
