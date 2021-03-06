object Hamming {

  def compute(strand1: String, strand2: String): Integer = {
    require(strand1.length == strand2.length, "Strands must be equal lengths.")

    strand1.zip(strand2).
      count{case (n1, n2) => n1 != n2}
  }

}