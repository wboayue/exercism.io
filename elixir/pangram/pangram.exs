defmodule Pangram do
  @doc """
  Determines if a word or sentence is a pangram.
  A pangram is a sentence using every letter of the alphabet at least once.

  Returns a boolean.

    ## Examples

      iex> Pangram.pangram?("the quick brown fox jumps over the lazy dog")
      true

  """
  @spec pangram?(String.t) :: boolean
  def pangram?(sentence) do
    count_unique_letters(sentence) == 26
  end

  defp alphabet?(c), do: ?a <= c && ?z >= c

  defp count_unique_letters(sentence) do
    String.downcase(sentence)
    |> String.to_charlist
    |> Enum.filter(&alphabet?/1)
    |> Enum.into(MapSet.new)
    |> MapSet.size
  end
end

# Enum.into(%{a: 1}, %{b: 2})