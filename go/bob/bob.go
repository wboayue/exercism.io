package bob

import (
	"strings"
	"unicode"
)

// Generates Bob's response to a remark
func Hey(remark string) string {
	remark = strings.TrimSpace(remark)

	switch {
	case isYell(remark) && isQuestion(remark):
		return "Calm down, I know what I'm doing!"
	case isYell(remark):
		return "Whoa, chill out!"
	case isQuestion(remark):
		return "Sure."
	case isSilence(remark):
		return "Fine. Be that way!"
	default:
		return "Whatever."
	}
}

func isQuestion(remark string) bool {
	return strings.HasSuffix(remark, "?")
}

func isYell(remark string) bool {
	return hasLetter(remark) && strings.ToUpper(remark) == remark
}

func hasLetter(remark string) bool {
	for _, r := range remark {
		if unicode.IsLetter(r) {
			return true
		}
	}
	return false
}

func isSilence(remark string) bool {
	return remark == ""
}
