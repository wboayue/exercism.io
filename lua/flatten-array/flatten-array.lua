function flatten(acc, source)
  for _, item in ipairs(source) do
    if type(item) == 'table' then
      flatten(acc, item)
    else
      table.insert(acc, item)
    end
  end
end

return function(source)
  local r = {}
  flatten(r, source)
  return r
end