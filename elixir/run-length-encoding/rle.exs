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
  def decode(encoded_string), do: do_decode(String.codepoints(encoded_string), "", "")

  defp do_decode([], decoded, _), do: decoded
  defp do_decode([code_point | rest], decoded, run_length) do
    if digit?(code_point) do
      run_length = run_length <> code_point
    else
      decoded = decoded <> String.duplicate(code_point, String.to_integer(run_length))
      run_length = ""
    end

    do_decode(rest, decoded, run_length)
  end

  defp digit?(code_point), do: String.match?(code_point, ~r/\d+/)

end
