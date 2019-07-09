package grains

import (
	"fmt"
	"math/big"
)

// Calculates number of grains on square
// number of grains is 2^(x-1)
func Square(x int) (uint64, error) {
	if x < 1 || x > 64 {
		return 0, fmt.Errorf("expected 1 to 64 got %d", x)
	}

	return 1 << uint(x-1), nil
}

// Calculates total number of grains
func Total() uint64 {
	return totalUpTo(64)
}

// total up to square x is 2^x - 1
func totalUpTo(x int64) uint64 {
	var i, e = big.NewInt(2), big.NewInt(x)

	i = i.Exp(i, e, nil)
	i = i.Sub(i, big.NewInt(1))

	return i.Uint64()
}
