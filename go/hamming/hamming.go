package hamming

import "fmt"

const testVersion = 5

// Calculates the Hamming difference between two DNA strands.
func Distance(strand1, strand2 string) (int, error) {
	if len(strand1) != len(strand2) {
		return 0, fmt.Errorf("strands must be equal lengths")
	}

	hammingDistance := 0

	for i, nucleotide := range strand1 {
		if nucleotide != rune(strand2[i]) {
			hammingDistance += 1
		}
	}

	return hammingDistance, nil
}
