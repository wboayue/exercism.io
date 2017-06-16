defmodule AllYourBase do
  @doc """
  Given a number in base a, represented as a sequence of digits, converts it to base b,
  or returns nil if either of the bases are less than 2
  """
  @spec convert(list, integer, integer) :: list
  def convert(digits, base_a, base_b) do
    if valid?(digits, base_a, base_b) do
      digits
      |> to_decimal(base_a)
      |> digits(base_b)
    else
      nil
    end
  end

  defp valid?(digits, base_a, base_b) do
    cond do
      Enum.empty?(digits)                          -> false
      Enum.any?(digits, &(&1 < 0 or &1 >= base_a)) -> false
      base_a < 2 or base_b < 2                     -> false
      :valid                                       -> true
    end
  end

  defp to_decimal(digits, base) do
    {_, total} = List.foldr(digits, {1, 0}, fn digit, {i, total} ->
      {i * base, i * digit + total}
    end)
    total
  end

  defp digits(num, base) do
    if div(num, base) == 0 do
      [rem(num, base)]
    else
      digits(div(num, base), base) ++ [rem(num, base)]
    end
  end
end
