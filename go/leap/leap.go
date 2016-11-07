package leap

// testVersion should match the targetTestVersion in the test file.
const testVersion = 2

func IsLeapYear(year int) bool {
	divisibleBy := func(factor int) bool { return year%factor == 0 }
	return divisibleBy(400) || (divisibleBy(4) && !divisibleBy(100))
}
