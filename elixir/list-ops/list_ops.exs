defmodule ListOps do
  # Please don't use any external modules (especially List) in your
  # implementation. The point of this exercise is to create these basic functions
  # yourself.
  #
  # Note that `++` is a function from an external module (Kernel, which is
  # automatically imported) and so shouldn't be used either.

  @spec count(list) :: non_neg_integer
  def count(list) do
    do_count(list, 0)
  end

  defp do_count([], count) do
    count
  end

  defp do_count([_ | tail], count) do
    do_count(tail, count + 1)
  end

  @spec reverse(list) :: list
  def reverse(list) do
    do_reverse(list, [])
  end

  defp do_reverse([], reversed) do
    reversed
  end

  defp do_reverse([head | tail], reversed) do
    do_count(tail, [head | reversed])
  end

  @spec map(list, (any -> any)) :: list
  def map(list, func) do
    do_map(list, func, [])
  end

  defp do_map([], func, mapped) do
    Enum.reverse(mapped)
  end

  defp do_map([head | tail], func, mapped) do
    do_map(tail, func, [func.(head) | mapped])
  end

  @spec filter(list, (any -> as_boolean(term))) :: list
  def filter(list, func) do
    do_filter(list, func, [])
  end

  defp do_filter([], func, filtered) do
    Enum.reverse(filtered)
  end

  defp do_filter([head | tail], func, filtered) do
    if func.(head) do
      filtered = [head | filtered]
    end

    do_filter(tail, func, filtered)
  end

  @type acc :: any
  @spec reduce(list, acc, ((any, acc) -> acc)) :: acc
  def reduce(list, acc, func) do
    do_reduce(list, acc, func)
  end

  defp do_reduce([], acc, func) do
    acc
  end

  defp do_reduce([head | tail], acc, func) do
    do_reduce(tail, func.(head, acc), func)
  end

  @spec append(list, list) :: list
  def append(a, b) do

  end

  @spec concat([[any]]) :: [any]
  def concat(ll) do

  end
end
