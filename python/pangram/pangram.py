# -*- coding: utf-8 -*-
import string

alphabet = set([x for x in string.ascii_lowercase])

def is_pangram(sentence):
  sentence = sentence.lower()
  letters = set([x for x in sentence])
  return alphabet.issubset(letters)
