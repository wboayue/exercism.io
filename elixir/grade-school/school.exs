defmodule School do
  @moduledoc """
  Simulate students in a school.

  Each student is in a grade.
  """

  @doc """
  Add a student to a particular grade in school.
  """
  @spec add(map, String.t, integer) :: map
  def add(db, name, grade) do
    Map.update(db, grade, [name], &([name | &1]))
  end

  @doc """
  Return the names of the students in a particular grade.
  """
  @spec grade(map, integer) :: [String.t]
  def grade(db, grade) do
    Map.get(db, grade, [])
  end

  @doc """
  Sorts the school by grade and name.
  """
  @spec sort(map) :: [{integer, [String.t]}]
  def sort(db) do
    db
    |> Enum.map(&sort_students/1)
    |> Enum.sort_by(&grade_sorter/1)
  end

  defp grade_sorter({grade, _}), do: grade
  defp sort_students({grade, students}), do: {grade, Enum.sort(students)}
end
