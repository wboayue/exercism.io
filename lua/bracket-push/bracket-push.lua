local open_brackets  = {['['] = true, ['{'] = true, ['('] = true}
local close_brackets = {[']'] = '[', ['}'] = '{', [')'] = '('}

local function valid(tokens)
  local stack = {}

  for token in tokens:gmatch('.') do
    if open_brackets[token] then
      table.insert(stack, token)
    elseif close_brackets[token] then
      if #stack == 0 or stack[#stack] ~= close_brackets[token] then
        return false -- unbalanced
      end
      table.remove(stack, #stack)
    end
  end

  return #stack == 0
end

return { valid = valid }