_base = ['zero', 'one', 'two', 'three', 'four', 'five',
         'six', 'seven', 'eight', 'nine', 'ten',
         'eleven', 'twelve', 'thirtheen', 'fourteen', 'fifteen',
         'sixteen', 'seventeen', 'eighteen', 'nineteen', 'twenty']

_tens = ['', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']

def say(n):
  if n < 0:
    raise AttributeError('number must be positive')

  if n >= 1_000_000_000_000:
    raise AttributeError('number must be less than 1 billion')

  if n >= 1_000_000_000:
    x, y = divmod(n, 1_000_000_000)
    if y == 0:
      return '{} billion'.format(say(int(x)))
    else:
      if y <= 10:
        return '{} billion and {}'.format(say(x), say(y))
      else:
        return '{} billion {}'.format(say(x), say(y))

  if n <= 20:
    return _base[n]

  if n < 100:
    x, y = divmod(n, 10)
    return '{}-{}'.format(_tens[x], say(y))

  if n < 1000:
    x, y = divmod(n, 100)
    if y == 0:
      return '{} hundred'.format(_base[x])
    else:
      return '{} hundred and {}'.format(_base[x], say(y))

  if n < 1_000_000:
    x, y = divmod(n, 1000)
    if y == 0:
      return '{} thousand'.format(say(x))
    else:
      return '{} thousand {}'.format(say(x), say(y))

  if n < 1_000_000_000:
    x, y = divmod(n, 1_000_000)
    if y == 0:
      return '{} million'.format(say(int(x)))
    else:
      if y <= 10:
        return '{} million and {}'.format(say(x), say(y))
      else:
        return '{} million {}'.format(say(x), say(y))


