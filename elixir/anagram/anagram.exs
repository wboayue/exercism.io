defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t, [String.t]) :: [String.t]
  def match(base, candidates) do
    match(base, letter_list_sorted(base), candidates)
  end

  defp match(base, base_list_sorted, candidates) do
    candidates
    |> Enum.filter(&(!equal_ignore_case?(base, &1) && anagram?(base_list_sorted, &1)))
  end

  defp equal_ignore_case?(a, b) do
    String.downcase(a) == String.downcase(b)
  end

  defp anagram?(base_list_sorted, word) do
    base_list_sorted == letter_list_sorted(word) 
  end

  defp letter_list_sorted(word) do
    word
    |> String.downcase
    |> String.to_char_list
    |> Enum.sort
  end
end
