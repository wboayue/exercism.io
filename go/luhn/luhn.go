package luhn

import "unicode"
import "fmt"

// Determines if number is valid per the Luhn formula
func Valid(number string) bool {
	digits, err := normalize(number)

	if err != nil {
		return false
	}

	if len(digits) == 1 {
		return false
	}

	sum := 0

	for i, digit := range digits {
		sum += checksum(i, digit)
	}

	return sum%10 == 0
}

// converts to int, removes spaces and reverses
func normalize(number string) ([]int, error) {
	digits := []rune(number)
	normalizedDigits := []int{}
	var digit rune

	for i, count := 0, len(digits); i < count; i++ {
		digit = digits[count-i-1]

		if unicode.IsSpace(digit) {
			continue
		}

		if !unicode.IsDigit(digit) {
			return []int{}, fmt.Errorf("only digits are allowed. found: %v", digit)
		}

		normalizedDigits = append(normalizedDigits, toInt(digit))
	}

	return normalizedDigits, nil
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
