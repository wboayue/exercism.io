defmodule DNA do
  @nucleotides [?A, ?C, ?G, ?T]
  @initial_summary %{?A => 0, ?T => 0, ?C => 0, ?G => 0}

  @doc """
  Counts individual nucleotides in a DNA strand.

  ## Examples

  iex> DNA.count('AATAA', ?A)
  4

  iex> DNA.count('AATAA', ?T)
  1
  """
  @spec count([char], char) :: non_neg_integer
  def count(strand, nucleotide) do
    validate_strand!(strand)
    validate_nucleotide!(nucleotide)

    Enum.count(strand, &(&1 == nucleotide))
  end

  defp validate_nucleotide!(nucleotide) do
    unless Enum.member?(@nucleotides, nucleotide), do: raise ArgumentError, message: "invalid nucleotide #{nucleotide}"
  end

  defp validate_strand!([]), do: nil
  defp validate_strand!([nucleotide | strand]) do
    validate_nucleotide!(nucleotide)
    validate_strand!(strand)
  end

  @doc """
  Returns a summary of counts by nucleotide.

  ## Examples

  iex> DNA.histogram('AATAA')
  %{?A => 4, ?T => 1, ?C => 0, ?G => 0}
  """
  @spec histogram([char]) :: map
  def histogram(strand) do
    validate_strand!(strand)

    Enum.reduce(strand, @initial_summary, fn(nucleotide, histogram) ->
      Map.update!(histogram, nucleotide, &(&1 + 1))
    end)
  end
end
