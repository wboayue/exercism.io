local alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
  'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}

local function count_letters(sentence)
  local counts = {}
  for letter in string.gmatch(string.lower(sentence), "[a-z]") do
    counts[letter] = (counts[letter] or 0) + 1
  end
  return counts
end

local function contains_all(counts, alphabet)
  for _, letter in pairs(alphabet) do
    if not counts[letter] then return false end
  end
  return true
end

return function(sentence)
  local counts = count_letters(sentence)
  return contains_all(counts, alphabet)
end
