local function word_count(sentence)
  local counts = {}
  for word in sentence:lower():gmatch('%w+') do
    counts[word] = (counts[word] or 0) + 1
  end
  return counts
end

return { word_count = word_count }
