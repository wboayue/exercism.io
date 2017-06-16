defmodule Tournament do
  @doc """
  Given `input` lines representing two teams and whether the first of them won,
  lost, or reached a draw, separated by semicolons, calculate the statistics
  for each team's number of games played, won, drawn, lost, and total points
  for the season, and return a nicely-formatted string table.

  A win earns a team 3 points, a draw earns 1 point, and a loss earns nothing.

  Order the outcome by most total points for the season, and settle ties by
  listing the teams in alphabetical order.
  """
  @spec tally(input :: list(String.t())) :: String.t()
  def tally(input) do
    input
    |> create_table
    |> format_table
  end

  defp create_table(input) do
    input
    |> Enum.map(&parse_line/1)
    |> Enum.reduce(%{}, &do_tally/2)
    |> Map.to_list
    |> Enum.sort_by(&tally_sorter/1)
  end

  defp tally_sorter({team, %{points: points}}), do: [-points, team]

  defp parse_line(line) do
    line
    |> String.split(";")
    |> List.to_tuple
  end

  defp do_tally({team_a, team_b, "loss"}, outcomes) do
    do_tally({team_b, team_a, "win"}, outcomes)
  end

  defp do_tally({team_a, team_b, "win"}, outcomes)  do
    outcomes_a = fetch_outcomes(outcomes, team_a) |> tally_win
    outcomes_b = fetch_outcomes(outcomes, team_b) |> tally_loss

    Map.merge(outcomes, %{team_a => outcomes_a, team_b => outcomes_b})
  end

  defp do_tally({team_a, team_b, "draw"}, outcomes)  do
    outcomes_a = fetch_outcomes(outcomes, team_a) |> tally_draw
    outcomes_b = fetch_outcomes(outcomes, team_b) |> tally_draw

    Map.merge(outcomes, %{team_a => outcomes_a, team_b => outcomes_b})
  end

  defp do_tally(_, outcomes), do: outcomes

  defp tally_win(outcomes) do
    %{  outcomes |
          won: outcomes[:won] + 1,
          points: outcomes[:points] + 3
      }
  end

  defp tally_loss(outcomes) do
    %{ outcomes | lost: outcomes[:lost] + 1 }
  end

  defp tally_draw(outcomes) do
    %{  outcomes |
          drawn: outcomes[:drawn] + 1,
          points: outcomes[:points] + 1
      }
  end

  defp fetch_outcomes(outcomes, team) do
    Map.get(outcomes, team, %{won: 0, lost: 0, drawn: 0, points: 0})
  end

  @header "Team                           | MP |  W |  D |  L |  P"

  defp format_table(rows) do
    Enum.join([@header | Enum.map(rows, &format_row/1)], "\n")
  end

  defp format_row({team, %{points: points, won: won, lost: lost, drawn: drawn}}) do
    String.pad_trailing(team, 30)
    <> " | "
    <> format_datapoints([won + lost + drawn, won, drawn, lost, points])
  end

  defp format_datapoints(datapoints) do
    datapoints
    |> Enum.map(&(String.pad_leading(Integer.to_string(&1), 2)))
    |> Enum.join(" | ")
  end
end
