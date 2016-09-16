defmodule PascalsTriangle do
  @doc """
  Calculates the rows of a pascal triangle
  with the given height
  """
  @spec rows(integer) :: [[integer]]
  def rows(num) do
    (0 .. num - 1) |> Enum.map(&build_row/1)
  end

  defp build_row(row) do
    (0 .. row) |> Enum.map(fn col -> cell(row, col) end)
  end

  defp cell(_, 0), do: 1
  defp cell(x, x), do: 1
  defp cell(row, col), do: cell(row - 1, col) + cell(row - 1, col - 1)

end
