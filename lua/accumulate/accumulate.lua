return function (items, map)
  local results = {}
  for i, item in ipairs(items) do
    results[i] = map(item)
  end
  return results
end
