require 'prime'

module Raindrops

  def self.convert(num)
    prime_factors = factorize(num)
    result = ""

    result += "Pling" if prime_factors.include?(3)
    result += "Plang" if prime_factors.include?(5)
    result += "Plong" if prime_factors.include?(7)

    result.empty? ? num.to_s : result
  end

  def self.factorize(num)
    Prime.prime_division(num).flatten    
  end

end

module BookKeeping
  VERSION = 2
end
