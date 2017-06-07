defmodule Strain do
  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns true.

  Do not use `Enum.filter`.
  """
  @spec keep(list :: list(any), fun :: ((any) -> boolean)) :: list(any)
  def keep(list, fun) do
    filter(list, fun)
  end

  defp filter(list, fun, acc \\ [])
  defp filter([], _fun, acc), do: Enum.reverse acc
  defp filter([x | xs], fun, acc) do
    if fun.(x), do: filter(xs, fun, [x | acc]), else: filter(xs, fun, acc)
  end

  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns false.

  Do not use `Enum.reject`.
  """
  @spec discard(list :: list(any), fun :: ((any) -> boolean)) :: list(any)
  def discard(list, fun) do
    filter(list, fn x -> !fun.(x) end)
  end
end
