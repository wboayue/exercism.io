# -*- coding: utf-8 -*-
from itertools import groupby

def encode(plain):
  return ''.join([encode_chunk(chunk) for chunk in chunks(plain)])

def chunks(plain):
  return [(run_type, len(list(run))) for run_type, run in groupby(plain)]

def encode_chunk(run):
  (run_type, run_length) = run
  if run_length == 1:
    return run_type
  else:
    return u"{0}{1}".format(run_length, run_type)

def decode(compressed):
  return compressed