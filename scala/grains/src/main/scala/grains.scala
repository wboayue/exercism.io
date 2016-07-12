// This exercise describes the geometric series derived from flipping
// the bits of a 64 bit binary number.
// http://www.regentsprep.org/regents/math/algtrig/atp2/geoseq.htm
object Grains {

  val CommonRatio = BigInt(2)

  def square(n: Int): BigInt = BigInt(0).setBit(n - 1)

  lazy val total = (1 - CommonRatio.pow(64)) / (1 - CommonRatio)
  
}