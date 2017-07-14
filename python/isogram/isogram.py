import string

def normalize(phrase):
  return sorted([x for x in phrase.lower() if x in string.lowercase])

def is_isogram(phrase):
  normalized = normalize(phrase) 
  return all([x != y for (x, y) in zip(normalized[:-1], normalized[1:])])
