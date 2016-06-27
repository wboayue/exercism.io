module Hamming

  def self.compute(strand1, strand2)
    raise ArgumentError, "strand lengths must be equal" if strand1.size != strand2.size

    combine_strands(strand1, strand2).count do |nucleotide1, nucleotide2|
      nucleotide1 != nucleotide2
    end
  end

  def self.combine_strands(strand1, strand2)
    strand1.chars.zip(strand2.chars)
  end

end

module BookKeeping
  VERSION = 3
end
