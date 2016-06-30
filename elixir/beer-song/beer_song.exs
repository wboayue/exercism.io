defmodule BeerSong do
  @doc """
  Get a single verse of the beer song
  """
  @spec verse(integer) :: String.t
  def verse(number) do
    bottles_of_beer_lyrics(number) <> take_one_down_lyrics(number)
  end

  def bottles_of_beer_lyrics(1) do
    "No more bottles of beer on the wall, no more bottles of beer.\n"
  end

  def bottles_of_beer_lyrics(2) do
    "1 bottle of beer on the wall, 1 bottle of beer.\n"
  end

  def bottles_of_beer_lyrics(number) do
    count = number - 1
    "#{count} bottles of beer on the wall, #{count} bottles of beer.\n"
  end

  def take_one_down_lyrics(1) do
    "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
  end

  def take_one_down_lyrics(2) do
    "Take it down and pass it around, no more bottles of beer on the wall.\n"
  end

  def take_one_down_lyrics(3) do
    "Take one down and pass it around, 1 bottle of beer on the wall.\n"
  end

  def take_one_down_lyrics(number) do
    "Take one down and pass it around, #{number - 2} bottles of beer on the wall.\n"
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
