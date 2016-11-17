package acronym

import "strings"
import "unicode"

const testVersion = 1

func isSeparator(char rune) bool {
	return char == ' ' || char == '-'
}

func isMixedCased(previous, current rune) bool {
	return unicode.IsLower(previous) && unicode.IsUpper(current)
}

func abbreviate(phrase string) string {
	previous := ' '
	acronym := []string{}

	for _, current := range phrase {
		if isSeparator(previous) || isMixedCased(previous, current) {
			acronym = append(acronym, string(current))
		}
		previous = current
	}

	return strings.ToUpper(strings.Join(acronym, ""))
}
