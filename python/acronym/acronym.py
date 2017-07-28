from re import findall

def abbreviate(phrase):
  return ''.join(findall(r'\b\w', phrase)).upper()
