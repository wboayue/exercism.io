function accumulate(items, map)
  results = {}
  for i, item in ipairs(items) do
    results[i] = map(item)
  end
  return results
end

return accumulate
