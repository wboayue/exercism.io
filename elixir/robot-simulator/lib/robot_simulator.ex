defmodule RobotSimulator do
  import Robot

  @valid_directions [:north, :east, :south, :west]

  @doc """
  Create a Robot Simulator given an initial direction and position.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec create(direction :: atom, position :: {integer, integer}) :: any
  def create(direction \\ :north, position \\ {0, 0}) do
    cond do
      invalid_direction?(direction) ->
        {:error, "invalid direction"}

      invalid_position?(position) ->
        {:error, "invalid position"}

      true ->
        %Robot{direction: direction, position: position}
    end
  end

  defp invalid_direction?(direction) do
    not Enum.member?(@valid_directions, direction)
  end

  defp invalid_position?({x, y}) when is_integer(x) and is_integer(y), do: false
  defp invalid_position?(_), do: true

  @doc """
  Simulate the robot's movement given a string of instructions.

  Valid instructions are: "R" (turn right), "L", (turn left), and "A" (advance)
  """
  @spec simulate(robot :: any, instructions :: String.t()) :: any
  def simulate(robot, instructions) do
    if instructions_valid?(instructions) do
      String.graphemes(instructions)
      |> Enum.reduce(robot, &move/2)
    else
      {:error, "invalid instruction"}
    end
  end

  defp instructions_valid?(instructions) do
    String.graphemes(instructions)
    |> Enum.all?(&(Enum.member?(["R", "L", "A"], &1)))
  end

  defp move("R", %Robot{direction: direction} = robot) do
    turn_right(robot, direction)
  end

  defp move("L", %Robot{direction: direction} = robot) do
    turn_left(robot, direction)
  end

  defp move("A", %Robot{direction: direction, position: position} = robot) do
    advance(robot, direction, position)
  end

  defp turn_right(robot, :north), do: %{robot | direction: :east}
  defp turn_right(robot, :east), do: %{robot | direction: :south}
  defp turn_right(robot, :south), do: %{robot | direction: :west}
  defp turn_right(robot, :west), do: %{robot | direction: :north}

  defp turn_left(robot, :north), do: %{robot | direction: :west}
  defp turn_left(robot, :east), do: %{robot | direction: :north}
  defp turn_left(robot, :south), do: %{robot | direction: :east}
  defp turn_left(robot, :west), do: %{robot | direction: :south}

  defp advance(robot, :north, {x, y}), do: %{robot | position: {x, y + 1}}
  defp advance(robot, :south, {x, y}), do: %{robot | position: {x, y - 1}}
  defp advance(robot, :east, {x, y}), do: %{robot | position: {x + 1, y}}
  defp advance(robot, :west, {x, y}), do: %{robot | position: {x - 1, y}}

  @doc """
  Return the robot's direction.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec direction(robot :: any) :: atom
  def direction(%Robot{direction: direction}), do: direction

  @doc """
  Return the robot's position.
  """
  @spec position(robot :: any) :: {integer, integer}
  def position(%Robot{position: position}), do: position
end
