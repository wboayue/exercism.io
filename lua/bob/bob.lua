local bob = {}

local function is_silence(sentence)
  return sentence:gsub(' ', '') == ''
end

local function is_shouting(sentence)
  return sentence:upper() == sentence
end

local function is_question(sentence)
  return sentence:sub(-1) == '?'
end

bob.hey = function(sentence)
  if is_silence(sentence) then return 'Fine, be that way.'
  elseif is_shouting(sentence) then return 'Whoa, chill out!'
  elseif is_question(sentence) then return 'Sure'
  else return 'Whatever'
  end
end

return bob
