package clock

import "fmt"
import "math"

const testVersion = 4

type Clock struct {
	hour, minute int
}

func floorDiv(x, y int) int {
	return int(math.Floor(float64(x) / float64(y)))
}

func floorMod(x, y int) int {
	return x - (floorDiv(x, y) * y)
}

func normalize(hour, minute int) (int, int) {
	m := floorMod(minute, 60)
	h := floorMod(hour+floorDiv(minute, 60), 24)
	return h, m
}

func New(hour, minute int) Clock {
	h, m := normalize(hour, minute)
	return Clock{h, m}
}

func (c Clock) String() string {
	return fmt.Sprintf("%02d:%02d", c.hour, c.minute)
}

func (c Clock) Add(minutes int) Clock {
	hour, minute := normalize(c.hour, c.minute+minutes)
	return Clock{hour, minute}
}
