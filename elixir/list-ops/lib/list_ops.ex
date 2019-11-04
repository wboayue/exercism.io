defmodule ListOps do
  # Please don't use any external modules (especially List or Enum) in your
  # implementation. The point of this exercise is to create these basic
  # functions yourself. You may use basic Kernel functions (like `Kernel.+/2`
  # for adding numbers), but please do not use Kernel functions for Lists like
  # `++`, `--`, `hd`, `tl`, `in`, and `length`.

  @spec count(list) :: non_neg_integer
  def count([]), do: 0
  def count([_ | tail]), do: 1 + count(tail)

  @spec reverse(list) :: list
  def reverse([]), do: []
  def reverse([head | tail]), do: reverse(tail, [head])
  def reverse([head | tail], reversed), do: reverse(tail, [head | reversed])
  def reverse([], reversed), do: reversed

  @spec map(list, (any -> any)) :: list
  def map([], _func), do: []
  def map([head | tail], func), do: [func.(head) | map(tail, func)]

  @spec filter(list, (any -> as_boolean(term))) :: list
  def filter([], _pred), do: []

  def filter([head | tail], pred) do
    case pred.(head) do
      true ->
        [head | filter(tail, pred)]

      _ ->
        filter(tail, pred)
    end
  end

  @type acc :: any
  @spec reduce(list, acc, (any, acc -> acc)) :: acc
  def reduce([], acc, _func), do: acc
  def reduce([head | tail], acc, func), do: reduce(tail, func.(head, acc), func)

  @spec append(list, list) :: list
  def append(a, b), do: do_append(reverse(a), b)
  def do_append([head | tail], b), do: do_append(tail, [head | b])
  def do_append([], b), do: b

  @spec concat([[any]]) :: [any]
  def concat([]), do: []
  def concat(ll), do: concat(ll, [])

  def concat([], acc), do: reverse(acc)

  def concat(list, acc) do
    {head, tail} = head_and_tail(list)
    concat(tail, [head | acc])
  end

  defp head_and_tail([[] | tail]), do: head_and_tail(tail)
  defp head_and_tail([head | tail]) when is_list(head), do: head_and_tail(head, tail)
  defp head_and_tail([head | tail]), do: {head, tail}

  defp head_and_tail([[] | tail], acc), do: head_and_tail(tail, acc)
  defp head_and_tail([head | []], acc), do: head_and_tail(head, acc)
  defp head_and_tail([head | tail], acc) when is_list(head), do: head_and_tail(head, [tail | acc])
  defp head_and_tail([head | tail], acc), do: {head, [tail | acc]}
  defp head_and_tail(head, acc), do: {head, acc}
end
