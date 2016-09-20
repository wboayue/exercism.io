defmodule Binary do
  @doc """
  Convert a string containing a binary number to an integer.

  On errors returns 0.
  """
  @spec to_decimal(String.t) :: non_neg_integer
  def to_decimal(string) do
    cond do
      String.match?(string, ~r/[^01]/) -> 0
      true -> convert(string)
    end
  end

  defp convert(string) do
    string
    |> String.graphemes
    |> Enum.reduce(0, fn digit, accum -> accum * 2 + String.to_integer(digit) end)
  end

end
