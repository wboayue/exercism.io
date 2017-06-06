defmodule SecretHandshake do
  @doc """
  Determine the actions of a secret handshake based on the binary
  representation of the given `code`.

  If the following bits are set, include the corresponding action in your list
  of commands, in order from lowest to highest.

  1 = wink
  10 = double blink
  100 = close your eyes
  1000 = jump

  10000 = Reverse the order of the operations in the secret handshake
  """
  use Bitwise, only_operators: true

  @actions [
    {0x1, "wink"},
    {0x2, "double blink"},
    {0x4, "close your eyes"},
    {0x8, "jump"}
  ]

  @reverse 0x10

  @spec commands(code :: integer) :: list(String.t())
  def commands(code) do
    results = @actions
    |> Enum.flat_map(fn {mask, action} -> if (code &&& mask) == mask, do: [action], else: [] end)

    if (code &&& @reverse) == @reverse do
      results |> Enum.reverse 
    else
      results 
    end
  end
end
