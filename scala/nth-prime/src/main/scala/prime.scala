import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Prime {

  def nth(count: Int) = {
    require(count > 0, "count must be greater than zero")
    primes.apply(count - 1)
  }

  def isFactor(num: Int, factor: Int): Boolean = num % factor == 0

  def primes(): Stream[Int] = {
    var candidate: Int = 2
    val knownPrimes = ArrayBuffer.empty[Int]

    @tailrec
    def nextPrime: Int = {
      if (knownPrimes.exists(isFactor(candidate, _))) {
        candidate += 1
        nextPrime
      } else {
        knownPrimes.append(candidate)
        candidate
      }
    }

    Stream.continually(nextPrime)
  }

}