require 'set'

class RandomNames

  attr_reader :letters, :digits

  def initialize
    @letters = 'A'.upto('Z').to_a
    @digits = 0.upto(9).to_a
  end

  def next
    generate_name
  end

  def generate_name
    (take_random(2, letters) + take_random(3, digits)).join
  end

  def take_random(num, items)
    1.upto(num).map { |i| items.sample }
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

  attr_reader :name

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
