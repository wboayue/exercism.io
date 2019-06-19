package gigasecond

import "time"

const (
	testVersion = 4
	gigaSecond  = 1e9 * time.Second
)

func AddGigasecond(birthday time.Time) time.Time {
	return birthday.Add(gigaSecond)
}