package scrabble

import "strings"

// Scores the given word
func Score(word string) int {
	scores := createScoresMap()
	score := 0

	for _, letter := range strings.ToUpper(word) {
		score += scores[letter]
	}

	return score
}

// Creates a mapping of letters to their values
func createScoresMap() map[rune]int {
	compactScores := map[string]int{
		"AEIOULNRST": 1,
		"DG":         2,
		"BCMP":       3,
		"FHVWY":      4,
		"K":          5,
		"JX":         8,
		"QZ":         10,
	}

	scores := make(map[rune]int)

	for letters, score := range compactScores {
		for _, letter := range letters {
			scores[letter] = score
		}
	}

	return scores
}
