defmodule Bob do
  def hey(phrase) do
    phrase = String.strip(phrase)

    cond do
      silence?(phrase) ->
        "Fine. Be that way!"
      question?(phrase) && shout?(phrase) ->
        "Calm down, I know what I'm doing!"
      shout?(phrase) ->
        "Whoa, chill out!"
      question?(phrase) ->
        "Sure."
      true ->
        "Whatever."
    end
  end

  defp silence?(phrase), do: phrase == ""  

  defp shout?(phrase), do: has_letter?(phrase) && String.upcase(phrase) == phrase 

  defp has_letter?(phrase), do: String.match?(phrase, ~r/\p{L}+/)  

  defp question?(phrase), do: String.ends_with?(phrase, "?")     
end
