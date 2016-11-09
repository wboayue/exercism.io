local M = {}

local char_at = function(text, i) return string.sub(text, i, i) end

M.compute = function(strand1, strand2)
  local hamming_distance = 0

  for i = 1, string.len(strand1) do
    if char_at(strand1, i) ~= char_at(strand2, i) then
      hamming_distance = hamming_distance + 1
    end
  end
  
  return hamming_distance 
end

return M