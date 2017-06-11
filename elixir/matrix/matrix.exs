defmodule Matrix do
  defstruct rows: nil

  @doc """
  Convert an `input` string, with rows separated by newlines and values
  separated by single spaces, into a `Matrix` struct.
  """
  @spec from_string(input :: String.t()) :: %Matrix{}
  def from_string(input) do
    %Matrix{rows: to_rows(input)}
  end

  defp to_rows(string) do
    String.split(string, "\n")
    |> Enum.map(&to_row/1)    
  end

  defp to_row(string) do
    string
    |> String.split
    |> Enum.map(fn s -> String.to_integer(s) end)    
  end

  @doc """
  Write the `matrix` out as a string, with rows separated by newlines and
  values separated by single spaces.
  """
  @spec to_string(matrix :: %Matrix{}) :: String.t()
  def to_string(%Matrix{rows: rows}) do
    Enum.map_join(rows, "\n", &(Enum.join(&1, " ")))
  end

  @doc """
  Given a `matrix`, return its rows as a list of lists of integers.
  """
  @spec rows(matrix :: %Matrix{}) :: list(list(integer))
  def rows(%Matrix{rows: rows}) do
    rows
  end

  @doc """
  Given a `matrix` and `index`, return the row at `index`.
  """
  @spec row(matrix :: %Matrix{}, index :: integer) :: list(integer)
  def row(%Matrix{rows: rows}, index) do
    Enum.at(rows, index)
  end

  @doc """
  Given a `matrix`, return its columns as a list of lists of integers.
  """
  @spec columns(matrix :: %Matrix{}) :: list(list(integer))
  def columns(matrix = %Matrix{rows: rows}) do
    width = Enum.count(hd(rows))
    Enum.map((0..width-1), &(column(matrix, &1)))
  end

  @doc """
  Given a `matrix` and `index`, return the column at `index`.
  """
  @spec column(matrix :: %Matrix{}, index :: integer) :: list(integer)
  def column(%Matrix{rows: rows}, index) do
    Enum.map(rows, &(Enum.at(&1, index)))
  end
end

