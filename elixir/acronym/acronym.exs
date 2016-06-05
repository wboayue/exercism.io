defmodule Acronym do
  @doc """
  Generate an acronym from a string. 
  "This is a string" => "TIAS"
  """
  @spec abbreviate(string) :: String.t()
  def abbreviate(string) do
    string
    |> split_camel_case
    |> split_words
    |> get_first_letter
    |> Enum.join
  end

  defp split_camel_case(string) do
    String.replace(string, ~r/([a-z])([A-Z])/, "\\1 \\2")
  end

  defp split_words(string) do
    String.split(string, [" ", "-"])
  end

  defp get_first_letter(words) do
    Enum.map(words, &(String.first(&1) |> String.capitalize))
  end

end
