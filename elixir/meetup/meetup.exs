defmodule Meetup do
  @moduledoc """
  Calculate meetup dates.
  """

  @type weekday ::
      :monday | :tuesday | :wednesday
    | :thursday | :friday | :saturday | :sunday

  @type schedule :: :first | :second | :third | :fourth | :last | :teenth

  @doc """
  Calculate a meetup date.

  The schedule is in which week (1..4, last or "teenth") the meetup date should
  fall.
  """
  @spec meetup(pos_integer, pos_integer, weekday, schedule) :: :calendar.date
  def meetup(year, month, weekday, schedule) do
    days_in_month(year, month)
    |> Enum.filter(&(to_weekday(Date.day_of_week(&1)) == weekday))
    |> day_for_schedule(schedule)
    |> Date.to_erl
  end

  def days_in_month(year, month) do
    num_days = Date.days_in_month(Date.from_erl!({year, month, 1}))
    Enum.map(1..num_days, &(Date.from_erl!({year, month, &1})))
  end

  def day_for_schedule(weekdays, :first), do: Enum.at(weekdays, 0)
  def day_for_schedule(weekdays, :second), do: Enum.at(weekdays, 1)
  def day_for_schedule(weekdays, :third), do: Enum.at(weekdays, 2)
  def day_for_schedule(weekdays, :fourth), do: Enum.at(weekdays, 3)
  def day_for_schedule(weekdays, :last), do: Enum.at(weekdays, -1)
  def day_for_schedule(weekdays, :teenth), do: Enum.find(weekdays, &(&1.day in 13..19))

  @weekdays %{
    1 => :monday, 2 => :tuesday,  3 => :wednesday, 4 => :thursday,
    5 => :friday, 6 => :saturday, 7 => :sunday
  }

  def to_weekday(day_num), do: @weekdays[day_num]
end
