def transform(legacy_data):
  transformed = {}

  for score, letters in legacy_data.items():
    for letter in letters:
      transformed[letter.lower()] = score
  
  return transformed
