local function do_find(items, item, lower_bound, upper_bound)
  if lower_bound > upper_bound then return -1 end

  local mid_ndx = math.floor((lower_bound + upper_bound) / 2)
  local mid_val = items[mid_ndx]

  if mid_val == item then return mid_ndx end

  if item > mid_val then
    return do_find(items, item, mid_ndx + 1, upper_bound)
  else
    return do_find(items, item, lower_bound, mid_ndx - 1)
  end
end

return function(items, item)
  return do_find(items, item, 1, #items)
end