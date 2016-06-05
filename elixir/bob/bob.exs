defmodule Bob do

  def hey(input) do
    input = String.strip(input)

    cond do
      silence?(input) -> "Fine. Be that way!"
      shout?(input) -> "Whoa, chill out!"
      question?(input) -> "Sure."
      true -> "Whatever."
    end
  end

  defp silence?(input) do
    input == ""  
  end

  defp shout?(input) do
    has_letter?(input) && String.upcase(input) == input  
  end

  defp has_letter?(input) do
    String.match?(input, ~r/\p{L}+/)  
  end

  defp question?(input) do
    String.ends_with?(input, "?")     
  end

end
