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

  defp process_bracket(_bracket, state = %{:valid => false}), do: state  
  defp process_bracket(bracket, state) when bracket in @open_brackts do
    push(state, bracket)
  end
  defp process_bracket(bracket, state) when bracket in @close_brackets do
    pop(state, bracket)
  end

  defp push(state = %{:valid => false}, _), do: state
  defp push(state, bracket) do
    %{state | :stack => [bracket | state[:stack]]}
  end

  defp pop(state = %{:valid => false}, _), do: state
  defp pop(state = %{:stack => []}, _), do: %{state | :valid => false}
  defp pop(%{:stack => stack} = state, bracket) do
    cond do
      hd(stack) == @bracket_pairs[bracket] -> %{state | :stack => tl(stack)}
      :unbalanced -> %{state | :valid => false}
    end
  end

  defp brackets_matched?(@initial_state), do: true
  defp brackets_matched?(_), do: false
end
