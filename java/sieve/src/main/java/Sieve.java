import java.util.BitSet;
import java.util.List;
import java.util.LinkedList;

public class Sieve {

  private int upperBound;

  public Sieve(int upperBound) {
    if (upperBound < 2) {
      throw new IllegalArgumentException("expected upper bound of 2 or larger");
    }
    this.upperBound = upperBound;
  }

  public List<Integer> getPrimes() {
    List<Integer> primes = new LinkedList<>();
    BitSet candidates = initializeBitSet(this.upperBound + 1);

    for (int candidate = candidates.nextSetBit(0); candidate != -1; candidate = candidates.nextSetBit(candidate + 1)) {
      primes.add(candidate);
      markNonPrimes(candidates, candidate, this.upperBound);
    }

    return primes;
  }

  private void markNonPrimes(BitSet candidates, int factor, int upperBound) {
    for (int i = factor * 2; i <= upperBound; i += factor) {
      candidates.clear(i);
    }
  }

  private BitSet initializeBitSet(int capacity) {
    BitSet set = new BitSet(capacity);
    set.set(0, capacity);
    set.clear(0, 2);
    return set;    
  }

}