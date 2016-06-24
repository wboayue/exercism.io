defmodule Words do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t) :: map
  def count(sentence) do
    sentence
    |> split_into_words
    |> count_words(%{})
  end

  defp split_into_words(sentence) do
    sentence
    |> String.downcase
    |> String.split(~r/[:!&@$%^ _,]+/, trim: true)
  end

  defp count_words([], counts) do
    counts
  end

  defp count_words([word | rest], counts) do
    count_words(rest, Map.update(counts, word, 1, &(&1 + 1)))
  end

end
