defmodule RunLengthEncoder do
  @doc """
  Generates a string where consecutive elements are represented as a data value and count.
  "HORSE" => "1H1O1R1S1E"
  For this example, assume all input are strings, that are all uppercase letters.
  It should also be able to reconstruct the data into its original form.
  "1H1O1R1S1E" => "HORSE"
  """
  @spec encode(String.t) :: String.t
  def encode("") do
    ""
  end

  def encode(string) do
    state = %{current: nil, run_length: 0, encoded: ""}
    
    String.codepoints(string)
    |> Enum.reduce(state, &encode/2)
    |> format_encoded_string
  end

  def encode(char, state) do
    cond do
      state[:current] == nil ->
        %{ state | :current => char, run_length: 1 }
      state[:current] == char ->
        %{ state | :run_length => (state[:run_length] + 1) }
      true ->
        %{ state | :encoded => "#{state[:encoded]}#{state[:run_length]}#{state[:current]}", :current => char, :run_length => 1 }
    end
  end

  defp format_encoded_string(state) do
    "#{state[:encoded]}#{state[:run_length]}#{state[:current]}"    
  end

  @spec decode(String.t) :: String.t
  def decode(string) do

  end
end
