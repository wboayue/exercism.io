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

  defp do_reverse([], result) do
    result
  end

  defp do_reverse([head | tail], result) do
    do_reverse(tail, [head | result])
  end

  @spec map(list, (any -> any)) :: list
  def map(list, func) do
    do_map(list, func, [])
  end

  defp do_map([], _, result) do
    reverse(result)
  end

  defp do_map([head | tail], func, result) do
    do_map(tail, func, [func.(head) | result])
  end

  @spec filter(list, (any -> as_boolean(term))) :: list
  def filter(list, func) do
    do_filter(list, func, [])
  end

  defp do_filter([], _, result) do
    reverse(result)
  end

  defp do_filter([head | tail], func, result) do
    if func.(head) do
      result = [head | result]
    end

    do_filter(tail, func, result)
  end

  @type acc :: any
  @spec reduce(list, acc, ((any, acc) -> acc)) :: acc
  def reduce(list, acc, func) do
    do_reduce(list, acc, func)
  end

  defp do_reduce([], acc, _) do
    acc
  end

  defp do_reduce([head | tail], acc, func) do
    do_reduce(tail, func.(head, acc), func)
  end

  @spec append(list, list) :: list
  def append(a, b) do
    do_append(Enum.reverse(a), b)
  end

  defp do_append(a, []) do
    reverse(a)
  end

  defp do_append(a, [head | tail]) do
    do_append([head | a], tail)
  end

  @spec concat([[any]]) :: [any]
  def concat([]) do
    []
  end

  def concat(ll) do
    do_concat(ll, [])
  end

  defp do_concat([], result) do
    reverse(result)
  end

  defp do_concat([[] | tail], result) do
    do_concat(tail, result)
  end

  defp do_concat([[head | nested] | tail], result) do
    do_concat([nested | tail], [head | result])
  end

  defp do_concat([head | tail], result) do
    do_concat(tail, [head | result])
  end

end
