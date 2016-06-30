defmodule BeerSong do
  @doc """
  Get a single verse of the beer song
  """
  @spec verse(integer) :: String.t
  def verse(number) do
    bottles_of_beer_lyrics(number) <> take_one_down_lyrics(number)
  end

  defp bottles_of_beer_lyrics(verse_number) do
    bottle_count = verse_number - 1
    sentence_case("#{beer_on_the_wall(bottle_count)}, #{pluralize("bottle", bottle_count)} of beer.\n")
  end

  defp pluralize(word, count) do
    case count do
      0 -> "no more #{word}s"
      1 -> "1 #{word}"
      _ -> "#{count} #{word}s"
    end
  end

  defp sentence_case(<< first_letter::binary-size(1) >> <> rest) do
    String.upcase(first_letter) <> rest
  end

  defp beer_on_the_wall(bottle_count) do
    "#{pluralize("bottle", bottle_count)} of beer on the wall"
  end

  defp take_one_down_lyrics(number) do
    case number do
      1 -> "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
      2 -> "Take it down and pass it around, no more bottles of beer on the wall.\n"
      _ -> "Take one down and pass it around, #{beer_on_the_wall(number - 2)}.\n"
    end
  end

  @doc """
  Get the entire beer song for a given range of numbers of bottles.
  """
  @spec lyrics(Range.t) :: String.t
  def lyrics(range) do
    range
    |> Enum.map(&verse/1)
    |> Enum.join("\n")
  end

  def lyrics, do: lyrics(100..1)

end
