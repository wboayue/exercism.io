from collections import defaultdict

GROUP_SIZE = 5

def encode(plain):
  cipher = _translate(plain.lower(), _make_translator('abcdefghijklmnopqrstuvwxyz'))
  return _format_cipher(cipher, GROUP_SIZE)

def decode(cipher):
  return _translate(cipher, _make_translator('zyxwvutsrqponmlkjihgfedcba'))

def _translate(text, mapper):
  return ''.join(mapper[x] for x in text)

def _make_translator(key):
  table = defaultdict(lambda: '')

  for x, y in zip(key, key[::-1]):
    table[x] = y

  for x  in '0123456789':
    table[x] = x

  return table

def _format_cipher(cipher, group_size):
  return ' '.join(cipher[i:i+group_size] for i in range(0, len(cipher), group_size))