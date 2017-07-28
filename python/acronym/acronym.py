from re import split

def abbreviate(phrase):
  return ''.join(word[0] for word in split(r'[ -]', phrase)).upper()
