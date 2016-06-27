defmodule Raindrops do

  @drops [
    {3, "Pling"},
    {5, "Plang"},
    {7, "Plong"}
  ]

  @doc """
  Returns a string based on raindrop factors.

  - If the number contains 3 as a prime factor, output 'Pling'.
  - If the number contains 5 as a prime factor, output 'Plang'.
  - If the number contains 7 as a prime factor, output 'Plong'.
  - If the number does not contain 3, 5, or 7 as a prime factor,
    just pass the number's digits straight through.
  """
  @spec convert(pos_integer) :: String.t
  def convert(number) do
    @drops
    |> Enum.filter(&(divisible_by?(number, &1)))
    |> Enum.map(&map_sound/1)
    |> format_melody(number)
 end

  defp divisible_by?(number, {factor, _}), do: rem(number, factor) == 0

  defp map_sound({_, sound}), do: sound

  defp format_melody([], number), do: "#{number}"
  defp format_melody(melody, number), do: Enum.join(melody)

end
