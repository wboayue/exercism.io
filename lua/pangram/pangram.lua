local function count_letters(sentence)
  local counts = {}
  for letter in sentence:lower():gmatch('[a-z]') do
    counts[letter] = (counts[letter] or 0) + 1
  end
  return counts
end

local function contains_all_alphabet(counts)
  alphabet = 'abcdefghijklmnopqrstuvwxyz'
  for letter in alphabet:gmatch('.') do
    if not counts[letter] then return false end
  end
  return true
end

return function(sentence)
  return contains_all_alphabet(count_letters(sentence))
end
