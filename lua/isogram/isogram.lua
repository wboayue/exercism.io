return function(word)
  local saw_letter = {}
  for letter in word:lower():gmatch('[a-z]') do
    if saw_letter[letter] then
      return false
    end
    saw_letter[letter] = true
  end
  return true
end