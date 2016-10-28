# -*- coding: utf-8 -*-

def hey(phrase):
  if is_silence(phrase):
    return "Fine. Be that way!"
  elif is_shouting(phrase):
    return "Whoa, chill out!"
  elif is_question(phrase):
    return "Sure."
  else:
    return "Whatever."

def is_silence(phrase):
  return not phrase.strip()

def is_question(phrase):
  return phrase.strip().endswith("?")

def is_shouting(phrase):
  return has_letter(phrase) and phrase.upper() == phrase

def has_letter(phrase):
  return any([c.isalpha() for c in phrase])
