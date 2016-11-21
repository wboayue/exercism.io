local M = {}

M.square_of_sums = function(x)
  local sum = 0
  for i = 1, x do
    sum = sum + i
  end
  return sum * sum
end

M.sum_of_squares = function(x)
  local sum = 0
  for i = 1, x do
    sum = sum + i * i
  end
  return sum
end

M.difference_of_squares = function(x)
  return M.square_of_sums(x) - M.sum_of_squares(x)
end

return M
