defmodule Acronym do
  @doc """
  Generate an acronym from a string.
  "This is a string" => "TIAS"
  """
  @spec abbreviate(String.t()) :: String.t()
  def abbreviate(string) do
    string
    |> split_into_words
    |> get_first_letter
    |> Enum.join
  end

  defp split_into_words(string) do
    String.split(string, ~r/(?=[[:upper:]])|[ -]/u)
  end

  defp get_first_letter(words) do
    Enum.map(words, &(&1 |> String.first |> String.capitalize))
  end

end
