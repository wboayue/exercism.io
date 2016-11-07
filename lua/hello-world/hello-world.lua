local exports = {}

function exports.hello(name)
  return "Hello, " .. (name or "world") .. "!"
end

return exports
