class Squares

  attr_reader :number_range

  def initialize(number)
    @number_range = (1..number)
  end

  def square_of_sum
    number_range.reduce(0, :+) ** 2
  end

  def sum_of_squares
    number_range.reduce(0) do |sum, x|
      sum + (x ** 2)
    end
  end

  def difference
    square_of_sum - sum_of_squares
  end

end

module BookKeeping
  VERSION = 3
end
