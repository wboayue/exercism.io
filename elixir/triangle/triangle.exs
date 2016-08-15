defmodule Triangle do
  @type kind :: :equilateral | :isosceles | :scalene

  @doc """
  Return the kind of triangle of a triangle with 'a', 'b' and 'c' as lengths.
  """
  @spec kind(number, number, number) :: { :ok, kind } | { :error, String.t }
  def kind(a, b, c) do
    sides = [a, b, c]

    cond do
      !all_sides_positive?(sides) -> {:error, "all side lengths must be positive"} 
      illogical?(sides) -> {:error, "side lengths violate triangle inequality"}
      :logical -> determine_type(sides) 
     end
  end

  defp all_sides_positive?(sides) do
    Enum.all?(sides, &(&1 > 0))  
  end

  defp illogical?(sides) do
    total_length = Enum.sum(sides)
    Enum.any?(sides, &(total_length - &1 <= &1))
  end

  defp determine_type(sides) do
    distinct_sides = MapSet.new(sides) |> MapSet.size

    case distinct_sides do
      1 -> { :ok, :equilateral } 
      2 -> { :ok, :isosceles } 
      3 -> { :ok, :scalene } 
    end    
  end


end
