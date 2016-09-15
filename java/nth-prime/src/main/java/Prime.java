import java.util.stream.LongStream;

public class Prime {
  
  public static long nth(int n) {
    if (n <  1) throw new IllegalArgumentException("n must be greater than 1");

    long[] primes = generatePrimes(n);

    return primes[primes.length-1];
  }

  private static long[] generatePrimes(long n) {
    return LongStream.iterate(2, i -> i + 1)
      .filter(Prime::isPrime)
      .limit(n)
      .toArray();
  }

  private static boolean isPrime(long n) {
    return LongStream.rangeClosed(2, (long)Math.sqrt(n))
      .allMatch(i -> n % i != 0);
  }

}