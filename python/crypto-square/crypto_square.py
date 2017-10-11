import re
import math


def encode(plain):
    normalized = _normalize(plain)

    if normalized == '':
        return ''

    return _cipher(*_rows(normalized))


def _normalize(plain):
    return re.sub(r'[^a-z0-9]', '', plain.lower())


def _rows(normalized):
    num_cols = math.ceil(math.sqrt(len(normalized)))
    rows = [normalized[i:i+num_cols] for i in range(0, len(normalized), num_cols)]
    return (num_cols, rows)


def _cipher(n, rows):
    blocks = []

    for x in range(n):
      block = []

      for y in range(len(rows)):
        if x < len(rows[y]):
          block.append(rows[y][x])

      blocks.append(''.join(block))

    return ' '.join(blocks)
