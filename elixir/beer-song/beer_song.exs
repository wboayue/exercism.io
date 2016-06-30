defmodule BeerSong do
  @doc """
  Get a single verse of the beer song
  """
  @spec verse(integer) :: String.t
  def verse(number) do
    bottles_of_beer_lyrics(number) <> take_one_down_lyrics(number)
  end

  defp pluralize(word, count, none \\ "no more") do
    case count do
      0 -> "#{none} #{word}s"
      1 -> "1 #{word}"
      _ -> "#{count} #{word}s"
    end
  end

  def bottles_of_beer_lyrics(verse_number) do
    bottle_count = verse_number - 1

    sentence_case("#{beer_on_the_wall(bottle_count)}, #{pluralize("bottle", bottle_count)} of beer.\n")
  end

  def sentence_case(<< first_letter::binary-size(1) >> <> rest) do
    String.upcase(first_letter) <> rest
  end

  def beer_on_the_wall(bottle_count) do
    "#{pluralize("bottle", bottle_count)} of beer on the wall"
  end

  def take_one_down_lyrics(1) do
    "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
  end

  def take_one_down_lyrics(2) do
    "Take it down and pass it around, #{beer_on_the_wall(0)}.\n"
  end

  def take_one_down_lyrics(number) do
    "Take one down and pass it around, #{beer_on_the_wall(number - 2)}.\n"
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

  def lyrics do
    lyrics(100..1)
  end
end
