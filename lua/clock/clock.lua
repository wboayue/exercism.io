local clock = {}
clock.__index = clock

local function normalize(hours, minutes)
  local state = {
    minutes = minutes % 60,
    hours = (hours + math.floor(minutes / 60)) % 24
  }
  return setmetatable(state, clock)
end

function clock.at(hours, minutes)
  return normalize(hours, minutes or 0)
end

function clock.__tostring(state)
  return string.format("%02d:%02d", state.hours, state.minutes)
end

function clock:equals(other)
  return tostring(self) == tostring(other)
end

function clock:minus(minutes)
  return normalize(self.hours, self.minutes - minutes)
end

function clock:plus(minutes)
  return normalize(self.hours, self.minutes + minutes)
end

return clock