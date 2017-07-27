from collections import defaultdict
from textwrap import wrap
import string

GROUP_SIZE = 5

def encode(plain):
  return _format_cipher(_translate(plain.lower()), GROUP_SIZE)

def decode(cipher):
  return _translate(cipher)

def _translate(text):
  mapper = _make_translator(string.ascii_lowercase)
  return ''.join(mapper[x] for x in text)

def _make_translator(key):
  table = defaultdict(lambda: '')

  for x, y in zip(key, key[::-1]):
    table[x] = y

  for x  in string.digits:
    table[x] = x

  return table

def _format_cipher(cipher, group_size):
  return ' '.join(wrap(cipher, group_size))
