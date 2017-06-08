defmodule PigLatin do
  @doc """
  Given a `phrase`, translate it a word at a time to Pig Latin.

  Words beginning with consonants should have the consonant moved to the end of
  the word, followed by "ay".

  Words beginning with vowels (aeiou) should have "ay" added to the end of the
  word.

  Some groups of letters are treated like consonants, including "ch", "qu",
  "squ", "th", "thr", and "sch".

  Some groups are treated like vowels, including "yt" and "xr".
  """
  @spec translate(phrase :: String.t()) :: String.t()
  def translate(phrase) do
    phrase
    |> String.split
    |> Enum.map_join(" ", &translate_word/1)
  end

  defp translate_word(word) do
    if starts_with_vowel?(word) do
      word <> "ay"
    else
      rotate(word) <> "ay"
    end
  end

  defp starts_with_vowel?(word), do: String.match?(word, ~r/^([aeiuo]|yt|xr).*/u)

  @consonants [
    ~r/^(sch)(.*)/u,
    ~r/^(thr)(.*)/u,
    ~r/^(\w?qu)(.*)/u,
    ~r/^(ch)(.*)/u,
    ~r/^(th)(.*)/u,
    ~r/^(\w)(.*)/u,
  ]

  defp rotate(word) do
    case Enum.find(@consonants, fn re -> String.match?(word, re) end) do
      nil -> word
      re  -> [_, consonant, base] = Regex.run(re, word); base <> consonant
    end
  end
end

