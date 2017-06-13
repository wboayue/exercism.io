defmodule SecretHandshake do
  use Bitwise, only_operators: true

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
  @spec commands(code :: integer) :: list(String.t())
  def commands(code) do
    Enum.reduce(actions(), [], fn {mask, action}, acc ->
      if (code &&& mask) == mask, do: action.(acc), else: acc
    end)
  end

  defp actions do
    [
      {0x1, make_action("wink")},
      {0x2, make_action("double blink")},
      {0x4, make_action("close your eyes")},
      {0x8, make_action("jump")},
      {0x10, &Enum.reverse/1}
    ]    
  end

  defp make_action(action), do: &(&1 ++ [action]) 
end
