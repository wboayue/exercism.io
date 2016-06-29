defmodule Year do
  @doc """
  Returns whether 'year' is a leap year.

  A leap year occurs:

  on every year that is evenly divisible by 4
    except every year that is evenly divisible by 100
      unless the year is also evenly divisible by 400
  """
  @spec leap_year?(non_neg_integer) :: boolean
  def leap_year?(year) do
    cond do
      not divisible_by?(year, 4) -> false
      not divisible_by?(year, 100) -> true
      not divisible_by?(year, 400) -> false
      :leap_year -> true
    end
  end

  defp divisible_by?(number, factor), do: rem(number, factor) == 0 
end

