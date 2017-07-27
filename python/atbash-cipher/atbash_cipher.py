from collections import defaultdict
# from bytes import maketrans

def _build_encoder_and_decoder():
  mapping = zip(
      'abcdefghijklmnopqrstuvwxyz0123456789',
      'zyxwvutsrqponmlkjihgfedcba0123456789')

  encode = defaultdict(None)
  decode = defaultdict()

  for x, y in mapping:
    encode[x] = y
    decode[y] = x

  return (encode, decode)

_ENCODER, _DECODER = _build_encoder_and_decoder()

def _make_translator(table):
  def translator(x):
    if x in table:
      return table[x]
    else:
      return ''
  return translator

def encode(plain):
  encode = _make_translator(_ENCODER)
  return ''.join([encode(x) for x in plain.lower()])

def decode(cipher):
  decode = _make_translator(_DECODER)
  return ''.join([decode(x) for x in cipher])
