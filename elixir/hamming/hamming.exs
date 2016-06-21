defmodule DNA do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> DNA.hamming_distance('AAGTCATA', 'TAGCGATC')
  4
  """
  @spec hamming_distance([char], [char]) :: non_neg_integer
  def hamming_distance(strand, strand), do: 0
  def hamming_distance(strand1, strand2) when length(strand1) != length(strand2), do: nil
  def hamming_distance(strand1, strand2) do
    Enum.zip(strand1, strand2)
    |> Enum.map(&compare_nucleotides/1)
    |> Enum.sum
  end

  defp compare_nucleotides({x, x}), do: 0
  defp compare_nucleotides({x, y}), do: 1
end
