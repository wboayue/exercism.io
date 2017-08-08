import string
import random

class Cipher(object):
    def __init__(self, key=None):
        self.key = key if key else self.generate_key()

        if not (self.key.isalpha() and self.key.islower()):
          raise ValueError('key must be only lowercase letters')

    def encode(self, plain_text):
        return self._rotate(''.join(filter(str.isalpha, plain_text.lower())), 1)

    def decode(self, cipher_text):
        return self._rotate(cipher_text, -1)

    def generate_key(self):
      return ''.join(random.choice(string.ascii_lowercase) for i in range(200))

    def _rotate(self, text, dir):
      return ''.join(_shift(text[i], _offset(self.key, i, dir))
                     for i in range(len(text)))

class Caesar(object):
    def __init__(self):
        self._cipher = Cipher("ddddddddddddddddd")

    def encode(self, plain_text):
        return self._cipher.encode(plain_text)

    def decode(self, cipher_text):
        return self._cipher.decode(cipher_text)

def _shift(x, y):
  x = ord(x) + y
  if x > ord('z'):
    x -= 26
  if x < ord('a'):
    x += 26
  return chr(x)

def _offset(key, i, dir):
  return (ord(key[i%len(key)]) - ord('a')) * dir
