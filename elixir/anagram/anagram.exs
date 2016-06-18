defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t, [String.t]) :: [String.t]
  def match(base, candidates) do
    base_bag = base |> word_bag

    candidates
    |> Enum.filter(&(String.downcase(base) != String.downcase(&1) && word_bag(&1) == base_bag))
  end

  defp word_bag(word) do
    word
    |> String.downcase
    |> String.codepoints
    |> Enum.sort
  end
end
