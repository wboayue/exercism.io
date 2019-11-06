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
    String.graphemes(instructions)
    |> Enum.reduce(robot, &perform/2)
  end

  defp perform("R", %Robot{direction: :north} = robot) do
    %{robot | direction: :east}
  end

  defp perform("R", %Robot{direction: :east} = robot) do
    %{robot | direction: :south}
  end

  defp perform("R", %Robot{direction: :south} = robot) do
    %{robot | direction: :west}
  end

  defp perform("R", %Robot{direction: :west} = robot) do
    %{robot | direction: :north}
  end

  defp perform("L", %Robot{direction: :north} = robot) do
    %{robot | direction: :west}
  end

  defp perform("L", %Robot{direction: :east} = robot) do
    %{robot | direction: :north}
  end

  defp perform("L", %Robot{direction: :south} = robot) do
    %{robot | direction: :east}
  end

  defp perform("L", %Robot{direction: :west} = robot) do
    %{robot | direction: :south}
  end

  defp perform("A", %Robot{direction: :north, position: {x, y}} = robot) do
    %{robot | position: {x, y + 1}}
  end

  defp perform("A", %Robot{direction: :east, position: {x, y}} = robot) do
    %{robot | position: {x + 1, y}}
  end

  defp perform("A", %Robot{direction: :south, position: {x, y}} = robot) do
    %{robot | position: {x, y - 1}}
  end

  defp perform("A", %Robot{direction: :west, position: {x, y}} = robot) do
    %{robot | position: {x - 1, y}}
  end

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
