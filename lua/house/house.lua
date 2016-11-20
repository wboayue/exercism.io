local M = {}

local items = {
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
  local rhyme = ""

  for i = num, 1, -1 do
    noun, verb = unpack(items[i])
    seperator = i == 1 and " " or "\n"
    rhyme = rhyme .. string.format(" the %s%sthat %s", noun, seperator, verb)
  end

  return "This is" .. rhyme
end

M.recite = function()
  local verses = {}
  for i = 1, 12 do
    verses[i] = M.verse(i)
  end
  return table.concat(verses, '\n')
end

return M