package space

type Planet string

const secondsInYear = 31557600

var orbitalPeriod = map[Planet]float64{
	"Earth":   1,
	"Mercury": 0.2408467,
	"Venus":   0.61519726,
	"Mars":    1.8808158,
	"Jupiter": 11.862615,
	"Saturn":  29.447498,
	"Uranus":  84.016846,
	"Neptune": 164.79132,
}

// Given an age in seconds,
// calculate how old someone is on specified planet
func Age(seconds float64, planet Planet) float64 {
	return earthAge(seconds) / orbitalPeriod[planet]
}

// converts seconds to earth years
func earthAge(seconds float64) float64 {
	return seconds / secondsInYear
}
