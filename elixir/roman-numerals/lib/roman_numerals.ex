defmodule RomanNumerals do
  @arabic_factors [
    { 1000, "M" },
    { 900, "CM" },
    { 500, "D" },
    { 400, "CD" },
    { 100, "C" },
    { 90, "XC" },
    { 50, "L" },
    { 40, "XL" },
    { 10, "X" },
    { 9, "IX" },
    { 5, "V" },
    { 4, "IV" },
    { 1, "I" }
  ]

  @doc """
  Convert the number to a roman number.
  """
  @spec numeral(pos_integer) :: String.t()
  def numeral(number) do
    numeral(number, @arabic_factors)
  end

  defp numeral(0, []), do: ""
  defp numeral(number, [{factor, roman} | factors]) do
    String.duplicate(roman, div(number, factor)) <> numeral(rem(number, factor), factors)
  end
end
