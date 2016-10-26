# -*- coding: utf-8 -*-

alphabet = set([chr(x) for x in xrange(ord('a'), ord('z'))])

def is_pangram(sentence):
  sentence = sentence.lower()
  letters = [sentence[i] for i in xrange(len(sentence))]
  return alphabet.issubset(letters)
  