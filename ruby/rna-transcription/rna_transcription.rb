module Complement

  DNA_RNA = {'G' => 'C', 'C' => 'G', 'T' => 'A', 'A' => 'U'}
  NUCLEOTIDES = DNA_RNA.keys

  def self.of_dna(dna)
    strand = dna.chars

    return '' unless dna_valid?(strand)

    strand.map { |nucleotide| DNA_RNA[nucleotide] }.join
  end

  def self.dna_valid?(strand)
    strand.all? { |nucleotide| NUCLEOTIDES.include?(nucleotide) }
  end

end

module BookKeeping
  VERSION = 4
end
