local M = {}

local noun_verb_pairs = {
  {"house", "Jack built."},
  {"malt", "lay in"},
  {"rat", "ate"},
  {"cat", "killed"},
  {"dog", "worried"},
  {"cow with the crumpled horn", "tossed"},
  {"maiden all forlorn", "milked"},
  {"man all tattered and torn", "kissed"},
  {"priest all shaven and shorn", "married"},
  {"rooster that crowed in the morn", "woke"},
  {"farmer sowing his corn", "kept"},
  {"horse and the hound and the horn", "belonged to"},
}

M.verse = function(num)
  local verse = ""

  for i = num, 1, -1 do
    noun, verb = unpack(noun_verb_pairs[i])
    seperator = i == 1 and " " or "\n"
    verse = verse .. string.format(" the %s%sthat %s", noun, seperator, verb)
  end

  return "This is" .. verse
end

M.recite = function()
  local verses = {}
  for i = 1, #noun_verb_pairs do
    verses[i] = M.verse(i)
  end
  return table.concat(verses, '\n')
end

return M