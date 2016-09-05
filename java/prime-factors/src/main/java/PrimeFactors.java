import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

  public static List<Long> getForNumber(long number) {
    List<Long> primes = new ArrayList();
    
    long factor = 2;
    long remainder = number;

    while (remainder != 1 && factor <= number) {
      if (remainder % factor == 0) {
        remainder /= factor;
        primes.add(factor);
      } else {
        factor += 1;
      }
    }

    return primes;
  }

}