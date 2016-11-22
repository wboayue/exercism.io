local Anagram = {}
Anagram.__index = Anagram

local function sort_letters(word)
  local letters = {}
  for c in string.lower(word):gmatch(".") do
    table.insert(letters, c)
  end
  table.sort(letters)
  return table.concat(letters)
end

function Anagram:new(word)
  return setmetatable({sorted_letters = sort_letters(word)}, Anagram)
end

function Anagram:match(words)
  local anagrams = {}
  for _, candidate in ipairs(words) do
    if self.sorted_letters == sort_letters(candidate) then
      table.insert(anagrams, candidate)
    end
  end
  return anagrams
end

return Anagram
