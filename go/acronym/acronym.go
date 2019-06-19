package acronym

import (
    "regexp"
    "strings"
)

const testVersion = 1

func Abbreviate(phrase string) string {
    re := regexp.MustCompile(`(\A|[ _-])+(\p{L})`)
	acronym := []string{}

    for _, match := range re.FindAllStringSubmatch(phrase, -1) {
    	acronym = append(acronym, match[2])
    }

	return strings.ToUpper(strings.Join(acronym, ""))
}
