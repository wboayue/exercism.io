defmodule Prime do

  @doc """
  Generates the nth prime.
  """
  @spec nth(non_neg_integer) :: non_neg_integer
  def nth(count) do
    case count do
      0 -> raise "count must be greater than zero"
      _ -> Enum.at(primes, count - 1) 
    end
  end

  defp primes do
    Stream.unfold({2, []}, &enumerate_primes/1)    
  end

  defp enumerate_primes({candidate, known_primes}) do
    prime = next_prime(candidate, known_primes)

    {prime, {prime, [prime | known_primes]}}  
  end

  defp next_prime(candidate, known_primes) do
    if Enum.any?(known_primes, &(rem(candidate, &1) == 0)) do
      next_prime(candidate + 1, known_primes)
    else
      candidate
    end
  end
end
