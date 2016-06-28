defmodule Bob do

  def hey(phrase) do
    phrase
    |> categorize
    |> respond
  end

  defp categorize(phrase) do
    cond do
      silence?(phrase) -> :silence
      shout?(phrase) -> :shout
      question?(phrase) -> :question
      :unknown -> :unknown
    end
  end

  defp silence?(input) do
    String.strip(input) == ""
  end

  defp shout?(input) do
    has_letter?(input) && String.upcase(input) == input
  end

  defp has_letter?(input) do
    String.match?(input, ~r/[[:alpha:]]+/u)
  end

  defp question?(input) do
    String.ends_with?(input, "?")
  end

  defp respond(category) do
    case category do
      :silence -> "Fine. Be that way!"
      :shout -> "Whoa, chill out!"
      :question -> "Sure."
      _ -> "Whatever."
    end
  end

end
