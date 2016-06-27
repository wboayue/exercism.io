require 'prime'

module Raindrops

  RAIN_DROPS = {
    3 => "Pling",
    5 => "Plang",
    7 => "Plong"
  }

  def self.convert(num)
    melody = RAIN_DROPS
      .select { |(factor, sound)| num % factor == 0 }
      .map { |(factor, sound)| sound }

    if melody.empty?
      num.to_s
    else
      melody.join
    end
  end

end

module BookKeeping
  VERSION = 2
end
