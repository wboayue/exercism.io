package twofer

import "strings"

const template = "One for X, one for me."

func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}

	return strings.ReplaceAll(template, "X", name)
}
