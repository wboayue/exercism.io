defmodule BeerSong do
  @doc """
  Get a single verse of the beer song
  """
  @spec verse(integer) :: String.t
  def verse(number) do
    bottles_of_beer_lyrics(number) <> take_one_down_lyrics(number)
  end

  defp bottles_of_beer_lyrics(verse_number) do
    bottle_count = verse_number
    sentence_case("#{beer_on_the_wall(bottle_count)}, #{pluralize("bottle", bottle_count)} of beer.\n")
  end

  defp pluralize(word, 0), do: "no more #{word}s"
  defp pluralize(word, 1), do: "1 #{word}"
  defp pluralize(word, count), do: "#{count} #{word}s"

  defp sentence_case(<< first_letter::binary-size(1) >> <> rest) do
    String.upcase(first_letter) <> rest
  end

  defp beer_on_the_wall(bottle_count) do
    "#{pluralize("bottle", bottle_count)} of beer on the wall"
  end

  defp take_one_down_lyrics(0) do
    "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
  end

  defp take_one_down_lyrics(1) do
    "Take it down and pass it around, no more bottles of beer on the wall.\n"
  end
  
  defp take_one_down_lyrics(number) do
    "Take one down and pass it around, #{beer_on_the_wall(number - 1)}.\n"
  end

  @doc """
  Get the entire beer song for a given range of numbers of bottles.
  """
  @spec lyrics(Range.t) :: String.t
  def lyrics(range \\ 99..0) do
    range
    |> Enum.map(&verse/1)
    |> Enum.join("\n")
  end

end
