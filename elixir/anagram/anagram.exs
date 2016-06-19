defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t, [String.t]) :: [String.t]
  def match(base, candidates) do
    base = String.downcase(base)
    match(base, sorted(base), candidates)
  end

  defp match(base, base_sorted, candidates) do
    candidates
    |> Enum.filter(&(anagram?(base, String.downcase(&1), base_sorted)))
  end

  defp sorted(word) do
    word
    |> String.to_char_list
    |> Enum.sort
  end

  defp anagram?(a, a, _), do: false
  defp anagram?(base, word, base_sorted) do
    base_sorted == sorted(word) 
  end

end
