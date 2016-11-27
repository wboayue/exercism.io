local function do_find(items, target, lower_bound, upper_bound)
  if lower_bound > upper_bound then return -1 end

  local mid_ndx = (lower_bound + upper_bound) // 2
  local mid_val = items[mid_ndx]

  if mid_val == target then return mid_ndx end

  if target > mid_val then
    return do_find(items, target, mid_ndx + 1, upper_bound)
  else
    return do_find(items, target, lower_bound, mid_ndx - 1)
  end
end

return function(items, target)
  return do_find(items, target, 1, #items)
end