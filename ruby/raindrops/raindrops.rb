module Raindrops

  RAIN_DROPS = {
    3 => "Pling",
    5 => "Plang",
    7 => "Plong"
  }

  def self.convert(num)
    melody = RAIN_DROPS
      .select { |(factor, sound)| (num % factor).zero? }
      .map { |(factor, sound)| sound }

    melody.empty? ? num.to_s :  melody.join
  end

end

module BookKeeping
  VERSION = 2
end
