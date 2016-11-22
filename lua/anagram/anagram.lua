local Anagram = {}
Anagram.__index = Anagram

local function word_bag(word)
  local bag = {}
  for c in string.lower(word):gmatch(".") do
    table.insert(bag, c)
  end
  table.sort(bag)
  return table.concat(bag)
end

function Anagram:new(word)
  local detector = {}
  setmetatable(detector, Anagram)
  detector.word_bag = word_bag(word)
  return detector
end

function Anagram:match(words)
  local anagrams = {}
  for _, candidate in ipairs(words) do
    if self.word_bag == word_bag(candidate) then
      table.insert(anagrams, candidate)
    end
  end
  return anagrams
end

return Anagram
