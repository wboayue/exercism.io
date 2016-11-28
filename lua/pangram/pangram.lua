local function count_letters(sentence)
  local counts = {}
  for letter in string.gmatch(string.lower(sentence), "[a-z]") do
    counts[letter] = (counts[letter] or 0) + 1
  end
  return counts
end

local function contains_all_alphabet(counts)
  for letter in string.gmatch('abcdefghijklmnopqrstuvwxyz', '.') do
    if not counts[letter] then return false end
  end
  return true
end

return function(sentence)
  return contains_all_alphabet(count_letters(sentence))
end
