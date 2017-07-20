def detect_anagrams(word, candidates):
  def is_anagram(candidate):
    if word.lower() == candidate.lower():
      return False
    else:
      return sorted(word.lower()) == sorted(candidate.lower())

  return [candidate for candidate in candidates if is_anagram(candidate)]
