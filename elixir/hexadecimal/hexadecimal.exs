defmodule Hexadecimal do
  @doc """
    Accept a string representing a hexadecimal value and returns the
    corresponding decimal value.
    It returns the integer 0 if the hexadecimal is invalid.
    Otherwise returns an integer representing the decimal value.

    ## Examples

      iex> Hexadecimal.to_decimal("invalid")
      0

      iex> Hexadecimal.to_decimal("af")
      175

  """

  @spec to_decimal(binary) :: integer
  def to_decimal(hex) do
    normalized_hex = String.upcase(hex)
    cond do
      String.match?(normalized_hex, ~r/[^0-9A-F]/) -> 0
      true -> convert(normalized_hex)
    end
  end

  defp convert(string) do
    string
    |> String.graphemes
    |> Enum.reduce(0, fn digit, accum ->
      accum * 16 + to_integer(digit)
    end)
  end

  defp to_integer("0"), do: 0
  defp to_integer("1"), do: 1
  defp to_integer("2"), do: 2
  defp to_integer("3"), do: 3
  defp to_integer("4"), do: 4
  defp to_integer("5"), do: 5
  defp to_integer("6"), do: 6
  defp to_integer("7"), do: 7
  defp to_integer("8"), do: 8
  defp to_integer("9"), do: 9
  defp to_integer("A"), do: 10
  defp to_integer("B"), do: 11
  defp to_integer("C"), do: 12
  defp to_integer("D"), do: 13
  defp to_integer("E"), do: 14
  defp to_integer("F"), do: 15
end

