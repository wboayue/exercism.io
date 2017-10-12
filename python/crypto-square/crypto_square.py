import math


def encode(plain_text):
    return _encode(_normalize(plain_text))


def _normalize(plain):
    return [c for c in plain.lower() if c.isalnum()]


def _encode(normalized_text):
    num_rows = math.ceil(math.sqrt(len(normalized_text)))
    return ' '.join(''.join(normalized_text[i::num_rows]) for i in range(num_rows))
