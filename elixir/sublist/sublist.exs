defmodule Sublist do
  @doc """
  Returns whether the first list is a sublist or a superlist of the second list
  and if not whether it is equal or unequal to the second list.
  """
  def compare([], []), do: :equal
  def compare([], _), do: :sublist
  def compare(_, []), do: :superlist
  def compare(a, b) do
    do_compare(Enum.sort(a), Enum.sort(b), [], [])
  end

  defp do_compare([], [], [], []), do: :equal
  defp do_compare([], _, [], _), do: :sublist
  defp do_compare(_, [], _, []), do: :superlist
  defp do_compare([], _, _, _), do: :unequal
  defp do_compare(_, [], _, _), do: :unequal
  defp do_compare(a, b, rem_a, rem_b) do
    cond do
      hd(a) === hd(b) ->
        do_compare(tl(a), tl(b), rem_a, rem_b)
      hd(a) < hd(b) ->
        do_compare(tl(a), b, [hd(a) | rem_a], rem_b)
      :hd_a_gt_hd_b ->
        do_compare(a, tl(b), rem_a, [hd(b) | rem_b])
    end  
  end

end
