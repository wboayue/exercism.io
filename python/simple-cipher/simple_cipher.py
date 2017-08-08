from string import ascii_lowercase
from random import choice

class Cipher(object):
    def __init__(self, key=None):
        self.key = key if key else self.generate_key()

        if not (self.key.isalpha() and self.key.islower()):
            raise ValueError('key must be only lowercase letters')

    def encode(self, plain_text):
        normalized_text = ''.join(filter(str.isalpha, plain_text.lower()))
        return self._rotate(normalized_text, 1)

    def decode(self, cipher_text):
        return self._rotate(cipher_text, -1)

    def generate_key(self):
        return ''.join(choice(ascii_lowercase) for i in range(200))

    def _rotate(self, text, direction):
        def shift(letter, i):
            offset = (ord(self.key[i%len(self.key)]) - ord('a')) * direction
            return ascii_lowercase[(ord(letter)+offset-ord('a')) % 26]

        return ''.join(shift(letter, i) for i, letter in enumerate(text))

class Caesar(object):
    def __init__(self):
        self._cipher = Cipher("ddddddddddddddddd")

    def encode(self, plain_text):
        return self._cipher.encode(plain_text)

    def decode(self, cipher_text):
        return self._cipher.decode(cipher_text)
