import string

_BASE = ['zero', 'one', 'two', 'three', 'four', 'five',
         'six', 'seven', 'eight', 'nine', 'ten',
         'eleven', 'twelve', 'thirtheen', 'fourteen', 'fifteen',
         'sixteen', 'seventeen', 'eighteen', 'nineteen', 'twenty']

_TENS = ['', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']

_THOUSANDS = ['', 'thousand', 'million', 'billion']

def say(n: int) -> string:
  if n < 0:
    raise AttributeError('number must be positive')

  if n >= 1e12:
    raise AttributeError('number must be less than 1 trillion')

  if n == 0:
    return 'zero'

  words = [_format_word(i, x)
            for i, x in enumerate(_split_into_thousands(n))
            if x]

  if len(words) > 1 and not 'and' in words[0]:
    words.insert(1, 'and')

  words.reverse()
  return ' '.join(words)

def _format_word(power: int, n: int) -> str:
  if power < 1:
    return '{}'.format(_to_words(n))
  else:
    return '{} {}'.format(_to_words(n), _THOUSANDS[power])

def _to_words(n):
  if n <= 20:
    return _BASE[int(n)]

  if n < 100:
    x, y = divmod(n, 10)
    return '{}-{}'.format(_TENS[int(x)], _to_words(y))

  x, y = divmod(n, 100)
  if y == 0:
    return '{} hundred'.format(_BASE[int(x)])

  return '{} hundred and {}'.format(_BASE[int(x)], _to_words(y))

def _split_into_thousands(n):
  x, y = divmod(n, 1000)

  thousands = list([y])

  while x:
    x, y = divmod(x, 1000)
    thousands.append(y)

  return thousands
