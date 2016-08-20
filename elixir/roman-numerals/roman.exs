defmodule Roman do
  @doc """
  Convert the number to a roman number.
  """
  @spec numerals(pos_integer) :: String.t
  def numerals(number) do
    components(number)
    |> Enum.map(&to_roman/1)
    |> Enum.join
  end

  defp components(number) do
    digits(number, [])
    |> Enum.reverse
    |> Enum.with_index
    |> Enum.map(fn {digit, i} -> digit * :math.pow(10, i) |> round end)
    |> Enum.reverse
  end

  defp digits(number, acc) do
    if div(number, 10) == 0 do
      [rem(number, 10) | acc]
    else
      digits(div(number, 10), [rem(number, 10) | acc])
    end  
  end

  defp to_roman(component) when component < 10 do
    case (component) do
      0 -> ""
      x when x in 1..3 -> String.duplicate("I", x)
      4 -> "IV"
      5 -> "V"
      x when x in 6..8 -> "V" <> String.duplicate("I", x - 5)
      9 -> "IX"
    end
  end

  defp to_roman(component)  do
    "L"   
  end

end
