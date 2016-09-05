import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class PrimeFactors {

  public static List<Long> getForNumber(long number) {
    List<Long> factors = new ArrayList();
    Primes primes = new Primes();
    factors.add(primes.next());
    factors.add(primes.next());
    factors.add(primes.next());
    factors.add(primes.next());
    factors.add(primes.next());
    factors.add(primes.next());
    factors.add(primes.next());
    factors.add(primes.next());
    return factors;
  }

  private static class Primes implements Iterator<Long> {

    private List<Long> knownPrimes = new ArrayList<>();
    private Long candidate = 2L;

    public Long next() {
      while (!isPrime(this.candidate)) {
        if (this.candidate == 2L) {
          this.candidate += 1L;
        } else {
          this.candidate += 2L;
        }
        break;
      }

      this.knownPrimes.add(candidate);
      this.candidate += 2L;

      return candidate;
    }

    private boolean isPrime(long number) {
      // can be more efficient by only checking to up sqrt(number)
      for (long prime : this.knownPrimes) {
        if (number % prime == 0) {
          return false;
        }
      }
      return true;
    }

    public boolean hasNext() {
      return true;
    }
  }

}