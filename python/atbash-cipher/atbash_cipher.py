from collections import defaultdict

GROUP_SIZE = 5

def encode(plain):
  encoder = _make_translator('abcdefghijklmnopqrstuvwxyz')
  return _format_cipher(''.join(encoder[x] for x in plain.lower()))

def decode(cipher):
  decoder = _make_translator('zyxwvutsrqponmlkjihgfedcba')
  return ''.join(decoder[x] for x in cipher)

def _make_translator(key):
  table = defaultdict(lambda: '')

  for x, y in zip(key, key[::-1]):
    table[x] = y

  for x  in '0123456789':
    table[x] = x

  return table

def _format_cipher(cipher):
  return ' '.join(cipher[i:i+GROUP_SIZE] for i in range(0, len(cipher), GROUP_SIZE))