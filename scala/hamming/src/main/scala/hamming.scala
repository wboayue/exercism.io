object Hamming {

  def compute(strand1: String, strand2: String): Integer = {
    if (strand1.length != strand2.length) {
      throw new IllegalArgumentException("Strands must be equals lengths.")
    }

    strand1.zip(strand2).
      filter({ case (nucleotide1, nucleotide2) => nucleotide1 != nucleotide2 }).
      length
  }

}