package hamming

import (
  "fmt"
)

const testVersion = 5

func Distance(strand1, strand2 string) (int, error) {
  if len(strand1) != len(strand2) {
    return 0, fmt.Errorf("strands must be equal lengths")
  }

  hamming_distance := 0

  for i, nucleotide := range(strand1) {
    if nucleotide != rune(strand2[i]) {
      hamming_distance += 1
    }
  }

  return hamming_distance, nil
}
