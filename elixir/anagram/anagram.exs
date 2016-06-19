defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t, [String.t]) :: [String.t]
  def match(base, candidates) do
    candidates
    |> Enum.filter(&(anagram?(String.downcase(base), String.downcase(&1))))
  end

  defp anagram?(a, a), do: false
  defp anagram?(base, word) do
    sorted(base) == sorted(word) 
  end

  defp sorted(word) do
    word
    |> String.to_char_list
    |> Enum.sort
  end

end
