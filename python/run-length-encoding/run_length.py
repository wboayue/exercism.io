# -*- coding: utf-8 -*-
from itertools import groupby

def encode(plain):
  return ''.join([encode_chunk(*chunk) for chunk in chunks(plain)])

def chunks(plain):
  return [(run_type, len(list(run))) for run_type, run in groupby(plain)]

def encode_chunk(run_type, run_length):
  if run_length == 1:
    return run_type
  else:
    return u"{0}{1}".format(run_length, run_type)

def decode(compressed):
  chunks = [decode_chunk(*chunk) for chunk in groupby(compressed, lambda x: x.isdigit())]
  plain = ''
  run_length = None
  for token in chunks:
    if isinstance(token, (long, int)):
      run_length = token
    else:
      if run_length:
        plain += token[0] * run_length
        if len(token) > 1:
          plain += token[1:]
        run_length = None
      else:
        plain += token

  return plain

def decode_chunk(is_digit, chunk):
  chunk = ''.join(list(chunk))
  if is_digit:
    return int(chunk)
  else:
    return chunk
 