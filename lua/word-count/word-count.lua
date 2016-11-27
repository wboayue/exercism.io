function word_count(sentence)
  local counts = {}
  for word in string.gmatch(string.lower(sentence), "[a-z0-9]+") do
    counts[word] = (counts[word] or 0) + 1
  end
  return counts
end

return { word_count = word_count }
