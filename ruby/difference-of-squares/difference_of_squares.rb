class Squares

  attr_reader :number

  def initialize(number)
    @number = number
  end

  def square_of_sum
    (1..number).reduce(0, :+) ** 2
  end

  def sum_of_squares
    (1..number).reduce(0) do |sum, x|
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
