defmodule Sublist do
  @doc """
  Returns whether the first list is a sublist or a superlist of the second list
  and if not whether it is equal or unequal to the second list.
  """
  def compare([], []), do: :equal
  def compare([], _), do: :sublist
  def compare(_, []), do: :superlist
  def compare(a, b) when length(a) > length(b), do: sublist(a, b, 0, :superlist)
  def compare(a, b), do: sublist(b, a, 0, :sublist)

  def sublist([], _b, _offset, _result_tag), do: :unequal
  def sublist(a, b, offset, result_tag) do
    case starts_with(a, b) do
      :equal -> if offset == 0, do: :equal, else: result_tag
      :starts_with -> result_tag
      :unequal -> sublist(tl(a), b, offset + 1, result_tag)
    end     
  end

  def starts_with([], []), do: :equal
  def starts_with(_, []), do: :starts_with
  def starts_with([], _), do: :unequal
  def starts_with(a, b) do
    cond do
      hd(a) === hd(b) -> starts_with(tl(a), tl(b))
      true -> :unequal
    end
  end

end
