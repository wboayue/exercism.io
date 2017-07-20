import string

LETTERS_IN_ALPHABET = 26

def shift(letter, key, alphabets):
  return alphabets[(alphabets.index(letter) + key) % LETTERS_IN_ALPHABET]

def encode(letter, key):
  if letter in string.ascii_lowercase:
    return shift(letter, key, string.ascii_lowercase)

  if letter in string.ascii_uppercase:
    return shift(letter, key, string.ascii_uppercase)

  return letter

def rotate(plain_text, key):
  return ''.join([encode(letter, key) for letter in plain_text])
