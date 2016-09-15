import java.util.List;
import java.util.ArrayList;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class Prime {
  
  public static long nth(int n) {
    if (n <  1) throw new IllegalArgumentException("n must be greater than 1");

    long[] primes = generatePrimes(n);

    return primes[primes.length-1];
  }

  private static long[] generatePrimes(long n) {
    return LongStream.iterate(2, i -> i + 1)
      .filter(new PrimePredicate())
      .limit(n)
      .toArray();
  }

  private static class PrimePredicate implements LongPredicate {

    private List<Long> knownPrimes = new ArrayList();
    
    public boolean test(long candidate) {
      boolean isPrime = this.knownPrimes.stream().allMatch(prime -> candidate % prime != 0);
      if (isPrime) {
        this.knownPrimes.add(candidate);
      }
      return isPrime;
    }
  }

}