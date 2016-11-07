package leap

// testVersion should match the targetTestVersion in the test file.
const testVersion = 2

func IsLeapYear(year int) bool {
	divisibleBy := func(year, factor int) bool { return year%factor == 0 }
	return divisibleBy(year, 400) || (divisibleBy(year, 4) && !divisibleBy(year, 100))
}
