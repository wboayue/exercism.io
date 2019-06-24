package isogram

import "unicode"

// Determines if a word is an isogram
func IsIsogram(word string) bool {
	seen := make(map[rune]bool)

	for _, letter := range word {
		if !unicode.IsLetter(letter) {
			continue
		}

		letter = unicode.ToLower(letter)

		if seen[letter] {
			return false
		}

		seen[letter] = true
	}

	return true
}
