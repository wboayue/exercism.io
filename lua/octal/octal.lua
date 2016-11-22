local function to_digits(number)
  local digits = {}
  for digit in string.gmatch(number, ".") do
    table.insert(digits, tonumber(digit))
  end
  return digits
end

local function is_valid(number)
  return string.match(number, '^[0-7]+$')
end

local function to_decimal(number)
  if is_valid(number) then
    local digits = to_digits(number)
    local decimal = 0
    for _, digit in ipairs(digits) do
      decimal = (decimal * 8) + digit
    end
    return decimal
  else
    return 0
  end
end

return function(number)
  return {to_decimal = function() return to_decimal(number) end}
end
