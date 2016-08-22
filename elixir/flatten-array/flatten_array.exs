defmodule Flattener do
  @doc """
    Accept a list and return the list flattened without nil values.

    ## Examples

      iex> Flattener.flatten([1, [2], 3, nil])
      [1,2,3]

      iex> Flattener.flatten([nil, nil])
      []

  """

  @spec flatten(list) :: list
  def flatten(list) do
    do_flatten(list, [])
  end

  defp do_flatten([], acc), do: Enum.reverse(acc)

  defp do_flatten([head | tail], acc) when head in [nil, []] do
    do_flatten(tail, acc)
  end

  defp do_flatten([head | tail], acc) when is_list(head) do
    do_flatten([hd(head) | [ tl(head) | tail]], acc)
  end

  defp do_flatten([head | tail], acc) do
    do_flatten(tail, [head | acc])
  end
end
