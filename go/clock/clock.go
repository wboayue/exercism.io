package clock

import "fmt"

const (
	minutesInDay  = minutesInHour * 24
	minutesInHour = 60
)

type Clock struct {
	hour, minute int
}

func New(hour, minute int) Clock {
	minutes := (hour*minutesInHour + minute) % minutesInDay
	if minutes < 0 {
		minutes += minutesInDay
	}

	return Clock{minutes / minutesInHour, minutes % minutesInHour}
}

func (c Clock) String() string {
	return fmt.Sprintf("%02d:%02d", c.hour, c.minute)
}

func (c Clock) Add(minutes int) Clock {
	return New(c.hour, c.minute+minutes)
}

func (c Clock) Subtract(minutes int) Clock {
	return New(c.hour, c.minute-minutes)
}
