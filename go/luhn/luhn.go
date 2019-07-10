package luhn

import "unicode"

// Determines if number is valid per the Luhn formula
func Valid(number string) bool {
	digits := []rune(number)
	validCount := 0
	sum := 0

	for i := len(digits) - 1; i >= 0; i-- {
		if unicode.IsSpace(digits[i]) {
			continue
		}

		if !unicode.IsDigit(digits[i]) {
			return false
		}

  		sum += checksum(validCount, toInt(digits[i]))
  		validCount += 1
	} 

	return validCount > 1 && sum%10 == 0
}

// converts rune digit to integer
func toInt(digit rune) int {
	return int(digit) - '0'
}

// computes the checksum for the digit
func checksum(i int, digit int) int {
	if i%2 == 0 {
		return digit
	}

	digit *= 2

	if digit > 9 {
		digit -= 9
	}

	return digit
}
