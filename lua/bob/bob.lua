local M = {}

local function is_silence(sentence)
  return string.gsub(sentence, " ", "") == ""
end

local function is_shouting(sentence)
  return string.upper(sentence) == sentence
end

local function is_question(sentence)
  return string.sub(sentence, -1) == "?"
end

M.hey = function(sentence)
  if is_silence(sentence) then return "Fine, be that way."
  elseif is_shouting(sentence) then return "Whoa, chill out!"
  elseif is_question(sentence) then return "Sure"
  else return "Whatever" 
  end
end

return M
