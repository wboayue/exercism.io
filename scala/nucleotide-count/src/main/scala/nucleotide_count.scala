class DNA(strand: String) {

  val Nucleotides = "ACGT"
  val InitialHistogram = Map('A' -> 0, 'T' -> 0, 'C' -> 0, 'G' -> 0)

  require(isValidStrand(), "Strand contains invalid nucleotides")

  def nucleotideCounts(): Map[Char, Int] = {
    strand.foldLeft(InitialHistogram) {
      (counts, nucleotide) => counts + (nucleotide -> (counts.getOrElse(nucleotide, 0) + 1))
    }
  }

  def nucleotideCounts(nucleotide: Char): Int = {
    require(isValidNucleotide(nucleotide), "Valid nucleotides are ACGT")

    strand.count(_ == nucleotide)
  }

  def isValidNucleotide(nucleotide: Char): Boolean = {
    Nucleotides.contains(nucleotide)
  }

  def isValidStrand(): Boolean = {
    strand forall isValidNucleotide
  }

}
