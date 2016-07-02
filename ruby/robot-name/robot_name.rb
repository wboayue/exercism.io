class RandomNames

  attr_reader :letters, :digits

  def initialize
    @letters = RandomBag.new
    @digits = RandomBag.new
  end

  def next
    (letters.take(2) + digits.take(4)).join
  end

end

class RandomBag
  def take(n)
    ['a']
  end
end

class Robot

  attr_reader :name, :names

  @@names = RandomNames.new

  def initialize
    reset
  end

  def reset
    @name = names.next
  end

  def names
    @@names
  end
end

module BookKeeping
  VERSION = 2
end
