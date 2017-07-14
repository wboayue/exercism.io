import string

def is_isogram(phrase):
  seen = set()

  for x in phrase.lower():
    if x.isalpha():
      if x in seen:
        return False
      else:
        seen.add(x)

  return True
