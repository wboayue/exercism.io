defmodule BracketPush do

  @initial_state %{:stack => [], :valid => true}

  @open_brackts ["[", "{", "("]
  @close_brackets ["]", "}", ")"]
  @all_brackets @open_brackts ++ @close_brackets
  @bracket_pairs Enum.zip(@close_brackets, @open_brackts) |> Enum.into(%{})

  @doc """
  Checks that all the brackets and braces in the string are matched correctly, and nested correctly
  """
  @spec check_brackets(String.t) :: boolean
  def check_brackets(str) do
    str
    |> String.codepoints
    |> Stream.filter(&bracket?/1)
    |> Enum.reduce(@initial_state, &process_bracket/2)
    |> brackets_matched?
  end

  defp bracket?(token) do
    Enum.member?(@all_brackets, token)  
  end

  defp process_bracket(_codepoint, state = %{:valid => false}), do: state
  defp process_bracket(codepoint, state) do
    case codepoint do
      bracket when bracket in @open_brackts -> push(state, bracket)
      bracket when bracket in @close_brackets -> pop(state, bracket)
    end
  end

  defp push(state = %{:valid => false}, _), do: state
  defp push(state, bracket) do
    %{state | :stack => [bracket | state[:stack]]}
  end

  defp pop(state = %{:valid => false}, _), do: state
  defp pop(%{:stack => stack} = state, bracket) do
    cond do
      stack == [] -> %{state | :valid => false}
      hd(stack) == @bracket_pairs[bracket] -> %{state | :stack => tl(stack)}
      true -> %{state | :valid => false}
    end
  end

  defp brackets_matched?(@initial_state), do: true
  defp brackets_matched?(_), do: false
end
