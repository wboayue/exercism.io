defmodule RotationalCipher do
  @doc """
  Given a plaintext and amount to shift by, return a rotated string.

  Example:
  iex> RotationalCipher.rotate("Attack at dawn", 13)
  "Nggnpx ng qnja"
  """
  @spec rotate(text :: String.t(), shift :: integer) :: String.t()
  def rotate(text, shift) do
    text
    |> to_charlist
    |> Enum.map(&rotate_letter(&1, shift))
    |> to_string
  end

  defp rotate_letter(letter, shift) when letter in ?a .. ?z, do: encode(?a, letter, shift)
  defp rotate_letter(letter, shift) when letter in ?A .. ?Z, do: encode(?A, letter, shift)
  defp rotate_letter(letter, _), do: letter

  defp encode(base, letter, shift), do: base + rem((letter - base) + shift, 26)
end
