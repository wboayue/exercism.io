local M = {}

local items = {
  {"", ""},
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

local generate_verse = function(num)
  local rhyme = string.format("This is the %s\n", items[num][1])

  for i = num, 2, -1 do
    rhyme = rhyme .. string.format("that %s the %s", items[i][2], items[i-1][1])

    if i > 2 then
      rhyme = rhyme .. "\n"
    end
  end

  rhyme = rhyme .. "house that Jack built."

  return rhyme  
end

M.verse = function(num)
  if num == 1 then
    return "This is the house that Jack built."
  else
    return generate_verse(num)
  end
end

M.recite = function()
  local verses = {}
  for i = 1, 12 do
    verses[i] = M.verse(i)
  end
  return table.concat(verses, '\n')
end

return M