def detect_anagrams(word, candidates):
  def is_anagram(candidate):
    return sorted(word.lower()) == sorted(candidate.lower()) and word.lower() != candidate.lower()

  return [candidate for candidate in candidates if is_anagram(candidate)]
