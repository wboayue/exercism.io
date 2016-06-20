defmodule BracketPush do

  @open_brackets ["[", "{", "("]
  @close_brackets ["]", "}", ")"]
  @all_brackets @open_brackets ++ @close_brackets
  @bracket_pairs Enum.zip(@close_brackets, @open_brackets) |> Enum.into(%{})

  @doc """
  Checks that all the brackets and braces in the string are matched correctly, and nested correctly
  """
  @spec check_brackets(String.t) :: boolean
  def check_brackets(str) do
    str
    |> String.codepoints
    |> balanced?([])
  end

  defp balanced?([], []), do: true  # balanced
  defp balanced?([], _), do: false  # unclosed

  # push
  defp balanced?([bracket | tokens], stack) when bracket in @open_brackets do
    balanced?(tokens, [bracket | stack])
  end

  # pop
  defp balanced?([bracket | tokens], stack) when bracket in @close_brackets do
    cond do
      stack == [] -> false
      hd(stack) == @bracket_pairs[bracket] -> balanced?(tokens, tl(stack))
      :unbalanced -> false
    end
  end

  # skip non-bracket
  defp balanced?([_token | tokens], stack), do: balanced?(tokens, stack)

end