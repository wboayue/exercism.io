defmodule Roman do
  @doc """
  Convert the number to a roman number.
  """
  @spec numerals(pos_integer) :: String.t
  def numerals(number) do
    components(number)
    |> Enum.map(&roman/1)
    |> Enum.join
  end

  defp components(number) do
    Integer.digits(number)
    |> Enum.reverse
    |> Enum.with_index
    |> Enum.filter(fn {digit,  _} ->  digit > 0 end)
    |> Enum.reverse
  end

  defp roman({digit, power}) do
    case digit do
      x when x in 1..3 -> String.duplicate(numeral(power), x)
      4 -> numeral(power) <> mid_numeral(power)
      5 -> mid_numeral(power)
      x when x in 6..8 -> mid_numeral(power) <> String.duplicate(numeral(power), x - 5)
      9 -> numeral(power) <> numeral(power + 1)
    end
  end

  defp numeral(power) do
    case power do
      0 -> "I"
      1 -> "X"
      2 -> "C"
      3 -> "M"
    end
  end

  defp mid_numeral(power) do
    case power do
      0 -> "V"
      1 -> "L"
      2 -> "D"
    end
  end

end
