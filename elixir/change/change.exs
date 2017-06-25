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
    candidates = permute(coins, target, [])
    if candidates == [] do
      {:error, "cannot change"}
    else
      {:ok, Enum.min_by(candidates, &Enum.count(&1))}
    end
  end

  def duplicate(_coin, 0), do: []
  def duplicate(coin, n) do
    (1..n) |> Enum.map(fn _ -> coin end)  
  end

  def permute([coin], target, candidate) do
    if rem(target, coin) == 0 do
      [candidate ++ duplicate(coin, div(target, coin))]
    else
      []
    end
  end

  def permute([coin | coins], target, candidate) do
    (0..div(target, coin))
    |> Enum.reduce([], fn i, acc ->
      acc ++ permute(coins, target - coin * i, candidate ++ duplicate(coin, i))
    end)
  end
end
