local M = {}

function M.hello(name)
  return string.format("Hello, %s!", (name or "world"))
end

return M
