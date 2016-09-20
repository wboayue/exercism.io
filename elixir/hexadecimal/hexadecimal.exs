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
    |> Enum.reduce(0, fn (digit, accum) ->
      accum * 16 + String.to_integer(digit, 16)
    end)
  end

end

