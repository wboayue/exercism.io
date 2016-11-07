function hello(name)
  name = name or "world"
	return "Hello, " .. name .. "!"
end

return { 
  hello = hello
}
