module Hamming

  def self.compute(strand1, strand2)
    raise ArgumentError, "strand lengths must be equal" if strand1.size != strand2.size

    combine_strands(strand1, strand2).reduce(0) do |hamming_distance, nucleotide_tuple|
      if nucleotide_tuple[0] == nucleotide_tuple[1]
        hamming_distance
      else
        hamming_distance + 1
      end
    end
  end

  def self.combine_strands(strand1, strand2)
    strand1.chars.zip(strand2.chars)
  end

end