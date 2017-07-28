from collections import defaultdict
from textwrap import wrap

def encode(plain, group_size = 5):
  return _format_cipher(_translate(plain.lower()), group_size)

def decode(cipher):
  return _translate(cipher)

def _translate(text):
  return ''.join(_flip(x) for x in text)

def _flip(ch):
  if 'a' <= ch <= 'z':
    return chr(ord('z') - (ord(ch) - ord('a')))
  elif '0' <= ch <= '9':
    return ch
  else:
    return ''

def _format_cipher(cipher, group_size):
  return ' '.join(wrap(cipher, group_size))
