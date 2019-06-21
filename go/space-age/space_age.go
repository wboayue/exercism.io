package space

import "fmt"

const secondsInYear = 31557600

type Planet string

// Given an age in seconds,
// calculate how old someone is on specified planet
func Age(seconds float64, planet Planet) float64 {
	return earthAge(seconds) / orbitalPeriod(planet)
}

// converts seconds to earth years
func earthAge(seconds float64) float64 {
	return seconds / secondsInYear
}

// determines the orbital period for a planet
func orbitalPeriod(planet Planet) float64 {
	switch planet {
	case "Earth":
		return 1
	case "Mercury":
		return 0.2408467
	case "Venus":
		return 0.61519726
	case "Mars":
		return 1.8808158
	case "Jupiter":
		return 11.862615
	case "Saturn":
		return 29.447498
	case "Uranus":
		return 84.016846
	case "Neptune":
		return 164.79132
	default:
		panic(fmt.Sprintf("Unknown planet %s", planet))
	}
}
