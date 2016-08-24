defmodule Garden do
  @doc """
    Accepts a string representing the arrangement of cups on a windowsill and a
    list with names of students in the class. The student names list does not
    have to be in alphabetical order.

    It decodes that string into the various gardens for each student and returns
    that information in a map.
  """

  @default_students ~w(alice bob charlie david eve fred ginny harriet ileana joseph kincaid larry)a

  @spec info(String.t(), list) :: map
  def info(info_string, student_names \\ @default_students) do
    do_info(info_string, Enum.sort(student_names))
  end

  defp do_info(info_string, students) do
    info_string
    |> build_garden(students)
    |> populate(default_garden(students))
  end

  defp default_garden(students) do
    Enum.into(students, %{}, fn name -> {name, {}} end)
  end

  defp build_garden(info_string, students) do
    String.split(info_string, "\n")
    |> Enum.flat_map(&(parse_row(&1, students)))
    |> Enum.group_by(&(elem(&1, 1)), &(elem(&1, 0)))
  end

  defp parse_row(row, students) do
    row
    |> String.graphemes
    |> Enum.map(&parse_plant/1)
    |> Enum.chunk(2)
    |> Enum.zip(students)
  end

  defp parse_plant("G"), do: :grass
  defp parse_plant("C"), do: :clover
  defp parse_plant("R"), do: :radishes
  defp parse_plant("V"), do: :violets

  defp populate(garden, default) do
    Enum.reduce(garden, default, fn {student, plants}, garden ->
      Map.put(garden, student, plants |> List.flatten |> List.to_tuple)
    end)
  end
end
