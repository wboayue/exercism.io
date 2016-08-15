defmodule SumOfMultiples do
  @doc """
  Adds up all numbers from 1 to a given end number that are multiples of the factors provided.
  """
  @spec to(non_neg_integer, [non_neg_integer]) :: non_neg_integer
  def to(limit, factors) do
    Enum.flat_map(factors, &(multiples(limit, &1)))
    |> Enum.uniq
    |> Enum.sum
  end

  defp multiples(limit, factors), do: multiples(limit, factors, [])
  defp multiples(limit, factor, []) when limit < factor, do: []
  defp multiples(limit, factor, []), do: multiples(limit, factor, [factor])
  defp multiples(limit, factor, items) do
    cond do
      hd(items) + factor < limit -> multiples(limit, factor, [hd(items) + factor | items])
      true -> items
    end
  end

end
