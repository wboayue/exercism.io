defmodule RunLengthEncoder do
  @doc """
  Generates a string where consecutive elements are represented as a data value and count.
  "HORSE" => "1H1O1R1S1E"
  For this example, assume all input are strings, that are all uppercase letters.
  It should also be able to reconstruct the data into its original form.
  "1H1O1R1S1E" => "HORSE"
  """
  @spec encode(String.t) :: String.t
  def encode(""), do: ""
  def encode(plain_string) do
    plain_string
    |> String.codepoints
    |> Stream.chunk_by(&(&1))
    |> Enum.map(&encode_run/1)
    |> Enum.join
  end

  defp encode_run(letters) do 
    "#{Enum.count(letters)}#{hd(letters)}"
  end

  @spec decode(String.t) :: String.t
  def decode(encoded_string) do
    encoded_string
    |> String.codepoints
    |> Stream.chunk_by(&(digit?(&1)))
    |> Stream.chunk(2)
    |> Enum.map(&decode_run/1)
    |> Enum.join
  end

  defp digit?(code_point), do: String.match?(code_point, ~r/\d+/)

  defp decode_run([length, letter]) do
    String.duplicate(hd(letter), String.to_integer(Enum.join(length)))
  end

end
