defmodule Isogram do
  @doc """
  Determines if a word or sentence is an isogram
  """
  @spec isogram?(String.t) :: boolean
  def isogram?(sentence) do
    sentence
    |> String.replace(~r/[ -]/, "")
    |> String.graphemes
    |> Enum.sort
    |> Enum.chunk(2, 1)
    |> Enum.all?(fn [x, y] -> x != y end)
  end

end
