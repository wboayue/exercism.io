package gigasecond

import "time"

const testVersion = 4

const gigaSecond = 1000000000 * time.Second

func AddGigasecond(birthday time.Time) time.Time {
	return birthday.Add(gigaSecond)
}
