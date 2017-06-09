defmodule Acronym do
  @doc """
  Generate an acronym from a string.
  "This is a string" => "TIAS"
  """
  @spec abbreviate(String.t()) :: String.t()
  def abbreviate(string) do
    string
    |> String.split(~r/(?=[[:upper:]])|[ -]/u)
    |> Enum.map_join(&capitalized_first/1)
  end

  defp capitalized_first(word) do
    word
    |> String.first
    |> String.capitalize
  end
end
