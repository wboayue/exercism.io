from collections import defaultdict
from textwrap import wrap

GROUP_SIZE = 5

def encode(plain):
  return _format_cipher(_rotate(plain.lower()), GROUP_SIZE)

def decode(cipher):
  return _rotate(cipher)

def _rotate(text):
  mapper = _make_translator('abcdefghijklmnopqrstuvwxyz')
  return ''.join(mapper[x] for x in text)

def _make_translator(key):
  table = defaultdict(lambda: '')

  for x, y in zip(key, key[::-1]):
    table[x] = y

  for x  in '0123456789':
    table[x] = x

  return table

def _format_cipher(cipher, group_size):
  return ' '.join(wrap(cipher, group_size))
