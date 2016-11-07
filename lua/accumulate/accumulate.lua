return function (items, f)
  local results = {}
  for i, item in ipairs(items) do
    results[i] = f(item)
  end
  return results
end
