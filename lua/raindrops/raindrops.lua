local sounds = {
  {3, "Pling"},
  {5, "Plang"},
  {7, "Plong"},
}

return function(num)
  melody = ""

  for _, tuple in ipairs(sounds) do
    factor, sound = unpack(tuple)
    if num % factor == 0 then
      melody = melody .. sound
    end
  end

  if melody == "" then
    return string.format("%s", num)
  else
    return melody
  end 
end