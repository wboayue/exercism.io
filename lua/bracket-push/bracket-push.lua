local M = {}

local open_brackets  = {["["] = "]", ["{"] = "}", ["("] = ")"}
local close_brackets = {["]"] = "[", ["}"] = "{", [")"] = "("}

M.valid = function(tokens)
  local stack = {}

  for token in string.gmatch(tokens, ".") do
    if open_brackets[token] ~= nil then
      table.insert(stack, token)
    elseif close_brackets[token] ~= nil then
      if #stack == 0 or stack[#stack] ~= close_brackets[token] then
        return false -- unbalanced
      end
      table.remove(stack, #stack)
    end
  end

  return #stack == 0
end

return M