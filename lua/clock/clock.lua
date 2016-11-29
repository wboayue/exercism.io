local Clock = {}
Clock.__index = Clock

local function normalize(hours, minutes)
  local state = {
    minutes = minutes % 60,
    hours = (hours + math.floor(minutes / 60)) % 24
  }
  return setmetatable(state, Clock)
end

function Clock.at(hours, minutes)
  return normalize(hours, minutes or 0)
end

function Clock.__tostring(state)
  return string.format("%02d:%02d", state.hours, state.minutes)
end

function Clock:equals(other)
  return tostring(self) == tostring(other)
end

function Clock:minus(minutes)
  return normalize(self.hours, self.minutes - minutes)
end

function Clock:plus(minutes)
  return normalize(self.hours, self.minutes + minutes)
end

return Clock