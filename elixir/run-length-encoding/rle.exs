defmodule RunLengthEncoder do
  @doc """
  Generates a string where consecutive elements are represented as a data value and count.
  "HORSE" => "1H1O1R1S1E"
  For this example, assume all input are strings, that are all uppercase letters.
  It should also be able to reconstruct the data into its original form.
  "1H1O1R1S1E" => "HORSE"
  """
  @spec encode(String.t) :: String.t
  def encode(""),  do: ""

  def encode(plain_string) do
    state = %{current: nil, run_length: 0, encoded: ""}
    
    String.codepoints(plain_string)
    |> Enum.reduce(state, &do_encode/2)
    |> encode_state
  end

  defp do_encode(char, state) do
    cond do
      first_character?(state) ->
        %{ state | :current => char, run_length: 1 }
      run_continues?(state, char) ->
        %{ state | :run_length => (state[:run_length] + 1) }
      # character changed
      true ->
        %{ state | :current => char, :run_length => 1, :encoded => encode_state(state) }
    end
  end

  defp first_character?(state), do: state[:current] == nil 

  defp run_continues?(state, char), do: state[:current] == char 

  defp encode_state(state) do
    "#{state[:encoded]}#{state[:run_length]}#{state[:current]}"    
  end

  @spec decode(String.t) :: String.t
  def decode(encoded_string), do: decode(String.codepoints(encoded_string), "", "")

  defp decode([], decoded, _), do: decoded

  defp decode([code_point | rest], decoded, run_length) do
    if digit?(code_point) do
      run_length = run_length <> code_point
    else
      decoded = decoded <> String.duplicate(code_point, String.to_integer(run_length))
      run_length = ""
    end

    decode(rest, decoded, run_length)
  end

  defp digit?(code_point), do: String.match?(code_point, ~r/\d+/)

end
