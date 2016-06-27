require 'prime'

module Raindrops

  RAIN_DROPS = {
    3 => "Pling",
    5 => "Plang",
    7 => "Plong"
  }

  def self.convert(num)
    melody = RAIN_DROPS.reduce("") do |melody, (factor, sound)|
      if num % factor == 0
        melody + sound
      else
        melody
      end
    end

    melody.empty? ? num.to_s : melody
  end

end

module BookKeeping
  VERSION = 2
end
