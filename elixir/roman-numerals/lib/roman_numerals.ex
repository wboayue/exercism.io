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
    {numerals, 0} = Enum.reduce(@arabic_factors, {"", number}, fn ({factor, roman}, {numerals, number}) ->
      {numerals <> String.duplicate(roman, div(number, factor)), rem(number, factor)}
    end)
    numerals
  end
end
