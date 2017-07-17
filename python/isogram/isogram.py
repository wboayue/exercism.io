def is_isogram(phrase):
  seen = set()

  for x in phrase.lower():
    if not x.isalpha():
      continue

    if x in seen:
      return False
    
    seen.add(x)

  return True
