defmodule Change do
  @doc """
    Determine the least number of coins to be given to the user such
    that the sum of the coins' value would equal the correct amount of change.
    It returns {:error, "cannot change"} if it is not possible to compute the
    right amount of coins. Otherwise returns the tuple {:ok, list_of_coins}

    ## Examples

      iex> Change.generate([5, 10, 15], 3)
      {:error, "cannot change"}

      iex> Change.generate([1, 5, 10], 18)
      {:ok, [1, 1, 1, 5, 10]}

  """

  @spec generate(list, integer) :: {:ok, list} | {:error, String.t}
  def generate(coins, 0), do: {:ok, []}
  def generate(coins, target) when target < 1, do: {:error, "cannot change"}
  def generate(coins, target) do
    build_tree(coins, target)
    |> Enum.filter(fn {_coins, _, score, _next} -> score == target end)
    |> Enum.min_by(fn {_coins, count, score, _next} -> count end)
    |> format
  end

  def build_tree(coins, target) do
    coins
    |> Enum.reduce([], &permutations(&1, &2, target))
  end

  def format({coins, count, score, {}}) do
    coins
  end

  def format({coins, count, score, _next}) do
    coins ++ format(_next) 
  end

  def duplicate(_coin, 0), do: []
  def duplicate(coin, num_coins) do
    (1..num_coins) |> Enum.map(fn _ -> coin end)
  end

  def permutations(coin, [], target) when coin > target do
    [ { [], 0, 0, {} } ]
  end

  def permutations(coin, [], target) do
    [0, div(target, coin)]
    |> Enum.map(fn num_coins ->
      { duplicate(coin, num_coins), num_coins, coin * num_coins, {} }
    end)
  end

  def permutations(coin, tree, target) do
    tree
    |> Enum.flat_map(fn node = {_, count, score, _} ->
        [0, div(target - score, coin)]
        |> Enum.map(fn i ->
          { duplicate(coin, i), i + count, coin * i + score, node }
        end)
      end)
  end
end
