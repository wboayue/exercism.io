defmodule Matrix do
  defstruct cells: nil, m: nil, n: nil

  @doc """
  Convert an `input` string, with rows separated by newlines and values
  separated by single spaces, into a `Matrix` struct.
  """
  @spec from_string(input :: String.t()) :: %Matrix{}
  def from_string(data) do
    cells = to_cells(data)
    {m, n} = bounds(cells)
    %Matrix{cells: cells, m: m, n: n}
  end

  defp to_cells(data) do
    String.split(data, "\n")
    |> Enum.with_index
    |> Enum.flat_map(&convert_row/1)
    |> Enum.into(%{})
  end

  defp convert_row({row, y}) do
    String.split(row)
    |> Enum.with_index
    |> Enum.map(fn {cell, x} -> {{y, x}, String.to_integer(cell)} end)    
  end

  defp bounds(cells) do
    Enum.reduce(Map.keys(cells), {0, 0}, fn {y, x}, {m, n} ->
      {Enum.max([y, m]), Enum.max([x, n])}
    end)
  end

  @doc """
  Write the `matrix` out as a string, with rows separated by newlines and
  values separated by single spaces.
  """
  @spec to_string(matrix :: %Matrix{}) :: String.t()
  def to_string(matrix) do
    Matrix.rows(matrix)
    |> Enum.map_join("\n", &(Enum.join(&1, " ")))
  end

  @doc """
  Given a `matrix`, return its rows as a list of lists of integers.
  """
  @spec rows(matrix :: %Matrix{}) :: list(list(integer))
  def rows(matrix = %Matrix{m: m}) do
    Enum.map((0..m), &(row(matrix, &1)))
  end

  @doc """
  Given a `matrix` and `index`, return the row at `index`.
  """
  @spec row(matrix :: %Matrix{}, index :: integer) :: list(integer)
  def row(%Matrix{cells: cells, n: n}, i) do
    Enum.map((0..n), &(Map.get(cells, {i, &1})))
  end

  @doc """
  Given a `matrix`, return its columns as a list of lists of integers.
  """
  @spec columns(matrix :: %Matrix{}) :: list(list(integer))
  def columns(matrix = %Matrix{n: n}) do
    Enum.map((0..n), &(column(matrix, &1)))
  end

  @doc """
  Given a `matrix` and `index`, return the column at `index`.
  """
  @spec column(matrix :: %Matrix{}, index :: integer) :: list(integer)
  def column(%Matrix{cells: cells, m: m}, i) do
    Enum.map((0..m), &(Map.get(cells, {&1, i})))
  end
end
