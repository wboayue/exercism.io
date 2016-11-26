local function is_valid(number)
  return string.match(number, '^[0-7]+$')
end

local function to_decimal(number)
  if not is_valid(number) then return 0 end

  local decimal = 0
  for digit in string.gmatch(number, ".") do
    decimal = (decimal * 8) + digit
  end

  return decimal
end

return function(number)
  return {to_decimal = function() return to_decimal(number) end}
end
