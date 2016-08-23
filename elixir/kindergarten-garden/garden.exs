defmodule Garden do
  @doc """
    Accepts a string representing the arrangement of cups on a windowsill and a
    list with names of students in the class. The student names list does not
    have to be in alphabetical order.

    It decodes that string into the various gardens for each student and returns
    that information in a map.
  """

  @students [
    :alice,
    :bob,
    :charlie,
    :david,
    :eve,
    :fred,
    :ginny,
    :harriet,
    :ileana,
    :joseph,
    :kincaid,
    :larry
  ]

  @plants %{
    "G" => :grass,
    "C" => :clover,
    "R" => :radishes,
    "V" => :violets
  }

  @spec info(String.t(), list) :: map
  def info(info_string, student_names \\ @students) do
    do_info(info_string, Enum.sort(student_names))
  end

  defp do_info(info_string, names) do
    gardens = Enum.into(names, %{}, fn name -> {name, {}} end)
    rows = String.split(info_string, "\n")

    Enum.reduce(rows, gardens, fn row, gardens ->
      planted_row = row |> String.graphemes |> Enum.with_index
      assign_plants(gardens, planted_row, names)
    end)
  end

  defp assign_plants(gardens, planted_row, names) do
    Enum.reduce(planted_row, gardens, fn {plant_id, index}, gardens ->
      student = Enum.at(names, div(index, 2))
      plant_name = @plants[plant_id]

      Map.update!(gardens, student, fn plants -> Tuple.append(plants, plant_name) end)
    end)
  end
end
