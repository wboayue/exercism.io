import string

LETTERS_IN_ALPHABET = 26

def shift(letter, key, last):
  shifted = ord(letter) + key

  if shifted > ord(last):
    shifted -= LETTERS_IN_ALPHABET

  return chr(shifted)

def encode(letter, key):
  if letter in string.ascii_lowercase:
    return shift(letter, key, 'z')

  if letter in string.ascii_uppercase:
    return shift(letter, key, 'Z')

  return letter

def rotate(plain_text, key):
  return ''.join([encode(letter, key) for letter in plain_text])
