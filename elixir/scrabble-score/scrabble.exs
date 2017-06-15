defmodule Scrabble do

  @raw_letter_values [
    {"aeioulnrst",  1},
    {"dg", 2},
    {"bcmp", 3},
    {"fhvwy", 4},
    {"k", 5},
    {"jx", 8},
    {"qz", 10},
  ]

  @letter_values for {letters, score} <- @raw_letter_values, letter <- String.graphemes(letters), do: {letter, score}, into: %{}

  @doc """
  Calculate the scrabble score for the word.
  """
  @spec score(String.t) :: non_neg_integer
  def score(word) do
    word
    |> String.downcase
    |> String.graphemes
    |> Enum.map(&score_letter/1)
    |> Enum.sum
  end

  defp score_letter(letter) do
    case Map.fetch(@letter_values, letter) do
      {:ok, value} -> value
      _            -> 0
    end
  end
end
