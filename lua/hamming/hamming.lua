local M = {}

local char_at = function(text, i) return text:sub(i, i) end

M.compute = function(strand1, strand2)
  local distance = 0
  for i = 1, #strand1 do
    if char_at(strand1, i) ~= char_at(strand2, i) then
      distance = distance + 1
    end
  end
  return distance 
end

return M