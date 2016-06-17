defmodule Sublist do
  @doc """
  Returns whether the first list is a sublist or a superlist of the second list
  and if not whether it is equal or unequal to the second list.
  """
  def compare([], []), do: :equal
  def compare([], _), do: :sublist
  def compare(_, []), do: :superlist
  def compare(a, b) do
    if Enum.count(a) > Enum.count(b) do
      case sublist(a, b, 0) do
        :sublist -> :superlist
        x -> x
      end
    else
      sublist(b, a, 0)
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

  def sublist([], _b, _offset), do: :unequal
  def sublist(a, b, offset) do
    case starts_with(a, b) do
      :equal -> if offset == 0, do: :equal, else: :sublist
      :starts_with -> :sublist
      :unequal -> sublist(tl(a), b, offset + 1)
    end     
  end

end
