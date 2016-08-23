defmodule Gigasecond do

  @giga_second 1_000_000_000

  @doc """
  Calculate a date one billion seconds after an input date.
  """
  @spec from({{pos_integer, pos_integer, pos_integer}, {pos_integer, pos_integer, pos_integer}}) :: :calendar.datetime
  def from(date_time) do
    date_time
    |> :calendar.datetime_to_gregorian_seconds
    |> Kernel.+(@giga_second)
    |> :calendar.gregorian_seconds_to_datetime
  end
end
