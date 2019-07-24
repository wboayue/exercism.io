package letter

import (
	"sync"
)

// FreqMap records the frequency of each rune in a given text.
type FreqMap map[rune]int

// Collects FreqMap for each given text
type ResultsChannel chan FreqMap

// Frequency counts the frequency of each rune in a given text and returns this
// data as a FreqMap.
func Frequency(s string) FreqMap {
	m := FreqMap{}
	for _, r := range s {
		m[r]++
	}
	return m
}

// Concurently counts the frequency of each rune in the givens texts.
// Returns data as FreqMap
func ConcurrentFrequency(texts []string) FreqMap {
	wg := &sync.WaitGroup{}
	frequencies := make(ResultsChannel) // collects results

	startWorkers(texts, &frequencies, wg)
	go signalWhenComplete(&frequencies, wg)

	return mergeResults(&frequencies)
}

// Starts a goroutine to count frequency for each text, publishes FreqMap for
// each text to ResultsChannel
func startWorkers(texts []string, frequencies *ResultsChannel, wg *sync.WaitGroup) {
	wg.Add(len(texts))

	for _, text := range texts {
		go func(text string) {
			*frequencies <- Frequency(text)
			wg.Done()
		}(text)
	}
}

func signalWhenComplete(frequencies *ResultsChannel, wg *sync.WaitGroup) {
	wg.Wait()
	close(*frequencies)
}

func mergeResults(frequencies *ResultsChannel) FreqMap {
	aggregate := FreqMap{}

	for m := range *frequencies {
		for letter, count := range m {
			aggregate[letter] += count
		}
	}

	return aggregate
}
