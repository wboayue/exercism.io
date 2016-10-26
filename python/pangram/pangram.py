# -*- coding: utf-8 -*-
import string

alphabet = set(string.ascii_lowercase)

def is_pangram(sentence):
  return alphabet.issubset(set(sentence.lower()))
