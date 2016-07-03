require 'set'

class RandomNames

  attr_reader :letters, :digits

  def initialize
    @letters = RandomNames.random_stream('A'.upto('Z'))
    @digits = RandomNames.random_stream(0.upto(9))
  end

  def next
    generate_name
  end

  def generate_name
    (letters.take(2) + digits.take(3)).join
  end

  def self.random_stream(items)
    Enumerator.new do |y|
      items = items.to_a

      loop do
        y << items.sample
      end
    end
  end

end

class UniqueStream

  def initialize(stream)
    @used = Set.new
    @stream = stream
  end

  def next
    loop do
      item = @stream.next

      return item if @used.add?(item)
    end
  end

end

class Robot

  attr_reader :name, :names

  @@names = UniqueStream.new(RandomNames.new)

  def initialize
    reset
  end

  def reset
    @name = @@names.next
  end

end

module BookKeeping
  VERSION = 2
end
