from collections import deque

_base = ['zero', 'one', 'two', 'three', 'four', 'five',
         'six', 'seven', 'eight', 'nine', 'ten',
         'eleven', 'twelve', 'thirtheen', 'fourteen', 'fifteen',
         'sixteen', 'seventeen', 'eighteen', 'nineteen', 'twenty']

_tens = ['', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']

_thousands = ['', 'thousand', 'million', 'billion']

def say(n):
  if n < 0:
    raise AttributeError('number must be positive')

  if n >= 1_000_000_000_000:
    raise AttributeError('number must be less than 1 trillion')

  if n == 0:
    return 'zero'

  def format(i, x):
    if i < 1:
      return '{}'.format(_to_words(x))
    else:
      return '{} {}'.format(_to_words(x), _thousands[i])

  words = [format (i, x)
          for i, x in enumerate(_split_into_thousands(n))
          if x]
  if len(words) > 1 and not 'and' in words[0]:
    words.insert(1, 'and')

  words.reverse()
  return ' '.join(words)

def _to_words(n):
  if n <= 20:
    return _base[int(n)]

  if n < 100:
    x, y = divmod(n, 10)
    return '{}-{}'.format(_tens[int(x)], _to_words(y))

  x, y = divmod(n, 100)
  if y == 0:
    return '{} hundred'.format(_base[int(x)])
  else:
    return '{} hundred and {}'.format(_base[int(x)], _to_words(y))

def _split_into_thousands(n):
  x, y = divmod(n, 1000)

  thousands = list([y])
  
  while x:
    x, y = divmod(x, 1000)
    thousands.append(y)
  
  return thousands
