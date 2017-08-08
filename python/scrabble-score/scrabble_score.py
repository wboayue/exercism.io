SCORES = {
    'AEIOULNRST': 1, 'DG': 2, 'BCMP': 3,
    'FHVWY': 4, 'K': 5, 'JX': 8, 'QZ': 10
}

LETTER_SCORES = {letter: score
                 for letters, score in SCORES.items() for letter in letters}

def score(word):
    return sum(LETTER_SCORES[letter] for letter in word.upper())
