defmodule Words do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t) :: map
  def count(sentence) do
    sentence
    |> strip_punctuation
    |> split_into_words
    |> drop_empty_words
    |> count_words
  end

  defp strip_punctuation(sentence) do
    String.replace(sentence, ~r/[:!&@$%^]/, "")
  end

  defp split_into_words(sentence) do
    String.downcase(sentence)
    |> String.split([" ", "_", ","])
  end

  defp drop_empty_words(words) do
    Enum.reject(words, &(&1 == ""))  
  end

  defp count_words(words) do
    count_words(words, %{})
  end

  defp count_words([], counts) do
    counts
  end

  defp count_words([word | rest], counts) do
    count_words(rest, Map.update(counts, word, 1, &(&1 + 1)))
  end

end
