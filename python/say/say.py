_BASE_TO_WORD = ['zero', 'one', 'two', 'three', 'four', 'five',
                 'six', 'seven', 'eight', 'nine', 'ten',
                 'eleven', 'twelve', 'thirtheen', 'fourteen', 'fifteen',
                 'sixteen', 'seventeen', 'eighteen', 'nineteen', 'twenty']

_TENS_TO_WORD = ['', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']

_THOUSANDS_TO_WORD = ['', 'thousand', 'million', 'billion']

def say(n):
  if n < 0:
    raise AttributeError('number must be positive')

  if n >= 1e12:
    raise AttributeError('number must be less than 1 trillion')

  if n == 0:
    return 'zero'

  words = [_format_word(i, x)
           for i, x in enumerate(_split_into_thousands(int(n)))
           if x]

  words = _insert_and(words)

  return ' '.join(reversed(words))

def _insert_and(words):
  if len(words) > 1 and not 'and' in words[0]:
    words = list(words)
    words.insert(1, 'and')

  return words

def _format_word(power, n):
  if power < 1:
    return '{}'.format(_to_words(n))

  return '{} {}'.format(_to_words(n), _THOUSANDS_TO_WORD[power])

def _to_words(n):
  if n <= 20:
    return _BASE_TO_WORD[n]

  if n < 100:
    x, y = divmod(n, 10)
    return '{}-{}'.format(_TENS_TO_WORD[x], _to_words(y))

  x, y = divmod(n, 100)
  if y == 0:
    return '{} hundred'.format(_BASE_TO_WORD[x])

  return '{} hundred and {}'.format(_BASE_TO_WORD[x], _to_words(y))

def _split_into_thousands(n):
  rest, chunk = divmod(n, 1000)
  thousands = [chunk]

  while rest:
    rest, chunk = divmod(rest, 1000)
    thousands.append(chunk)

  return thousands
