local function concat(list1, list2)
  for _, item in ipairs(list2) do
    table.insert(list1, item)
  end
end

local function flatten(items)
  local results = {}
  for _, item in ipairs(items) do
    if type(item) == 'table' then
      concat(results, flatten(item))
    else
      table.insert(results, item)
    end
  end
  return results
end

return flatten