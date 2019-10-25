defmodule Words do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t) :: map
  def count(sentence) do
    sentence
    |> split_into_words
    |> count_words
  end

  defp split_into_words(sentence) do
    sentence
    |> String.downcase
    |> String.split(~r/[^[:alnum:]-]+/u, trim: true)
  end

  defp count_words(words) do
    Enum.reduce(words, %{}, &update_counts/2)
  end

  defp update_counts(word, counts) do
    Map.update(counts, word, 1, &(&1 + 1))
  end
end
