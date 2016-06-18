defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t, [String.t]) :: [String.t]
  def match(base, candidates) do
    match(base, letter_bag(base), candidates)
  end

  defp match(base, base_bag, candidates) do
    candidates
    |> Enum.filter(&(!equal_ignore_case?(base, &1) && anagram?(base_bag, &1)))
  end

  defp equal_ignore_case?(a, b) do
    String.downcase(a) == String.downcase(b)
  end

  defp anagram?(base_bag, word) do
    base_bag == letter_bag(word) 
  end

  defp letter_bag(word) do
    word
    |> String.downcase
    |> String.to_char_list
    |> Enum.sort
  end
end
