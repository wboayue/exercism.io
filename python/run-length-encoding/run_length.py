# -*- coding: utf-8 -*-
import re

def encode(plain):
  def encode_match(match):
    return u"{0}{1}".format(len(match.group(0)), match.group(1))

  return re.sub(r"(.)\1+", encode_match, plain) # match 2 or more characters

def decode(compressed):
  def decode_match(match):
    return match.group(2) * int(match.group(1))

  return re.sub(r"(\d+)(\D)", decode_match, compressed)
