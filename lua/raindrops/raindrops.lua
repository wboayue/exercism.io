local sounds = {
  {3, "Pling"},
  {5, "Plang"},
  {7, "Plong"},
}

return function(num)
  local melody = ""

  for _, tuple in ipairs(sounds) do
    local factor, sound = unpack(tuple)
    if num % factor == 0 then
      melody = melody .. sound
    end
  end

  return melody == "" and tostring(num) or melody
end