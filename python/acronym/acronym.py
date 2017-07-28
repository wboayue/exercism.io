import re

def abbreviate(phrase):
  return ''.join(word[0].upper() for word in re.split(r'[ -]', phrase))
