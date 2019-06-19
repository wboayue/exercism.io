package leap

// Given a year, report if it is a leap year.
func IsLeapYear(year int) bool {
	divisibleBy := func(factor int) bool { return year%factor == 0 }
	return divisibleBy(400) || (divisibleBy(4) && !divisibleBy(100))
}
