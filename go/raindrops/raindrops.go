package raindrops

import "strconv"

const testVersion = 2

type factor struct {
	factor int
	output string
}

var factors = []factor{factor{3, "Pling"}, factor{5, "Plang"}, factor{7, "Plong"}}

func Convert(x int) string {
	converted := ""

	for _, tuple := range factors {
		if x%tuple.factor == 0 {
			converted += tuple.output
		}
	}

	if converted != "" {
		return converted
	} else {
		return strconv.Itoa(x)
	}
}
