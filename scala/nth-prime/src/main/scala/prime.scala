import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Prime {

  def nth(count: Int) = {
    require(count > 0, "count must be greater than zero")
    primes(count - 1)
  }

  def isFactor(num: Int, factor: Int): Boolean = num % factor == 0

  lazy val primes: Stream[Int] = {
    val knownPrimes = ArrayBuffer.empty[Int]

    def isPrime(candidate: Int): Boolean = {
      if (knownPrimes.exists(isFactor(candidate, _))) {
        false
      } else {
        knownPrimes.append(candidate)
        true
      }
    }

    Stream.from(2) filter isPrime
  }

}