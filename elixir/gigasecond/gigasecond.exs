defmodule Gigasecond do

  @giga_seconds 1_000_000_000

  @doc """
  Calculate a date one billion seconds after an input date.
  """
  @spec from({{pos_integer, pos_integer, pos_integer}, {pos_integer, pos_integer, pos_integer}}) :: :calendar.datetime
  def from(date_time) do
    gregorian_seconds = :calendar.datetime_to_gregorian_seconds(date_time)
    :calendar.gregorian_seconds_to_datetime(gregorian_seconds + @giga_seconds)
  end
end
