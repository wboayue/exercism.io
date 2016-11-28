local function parse_row(serialized)
  local cols = {}
  for col in serialized:gmatch('%d+') do
    table.insert(cols, tonumber(col))
  end
  return cols
end

local function parse(serialized)
  local rows = {}
  for row in serialized:gmatch('[^\n]+') do
    table.insert(rows, parse_row(row))
  end
  return rows
end

return function(serialized)
  local matrix = parse(serialized)

  function matrix.column(i)
    local cols = {}
    for _, row in ipairs(matrix) do
      table.insert(cols, row[i])
    end
    return cols
  end

  function matrix.row(i)
    return matrix[i]
  end

  return matrix
end
