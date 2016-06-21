defmodule Accumulate do
  @doc """
    Given a list and a function, apply the function to each list item and
    replace it with the function's return value.

    Returns a list.

    ## Examples

      iex> Accumulate.accumulate([], fn(x) -> x * 2 end)
      []

      iex> Accumulate.accumulate([1, 2, 3], fn(x) -> x * 2 end)
      [2, 4, 6]

  """

  @spec accumulate(list, (any -> any)) :: list
  def accumulate(list, fun) do
    do_accumlate(list, fun, [])
  end

  defp do_accumlate([], _, acc), do: Enum.reverse(acc)
  defp do_accumlate([head | tail], fun, acc) do
    do_accumlate(tail, fun, [fun.(head) | acc])
  end
end
