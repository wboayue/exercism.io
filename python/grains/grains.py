def on_square(x):
  _validate_square(x)
  return 2**(x-1)

def total_after(x):
  _validate_square(x)
  return 2**x - 1

def _validate_square(x):
  if not 0 < x <= 64:
    raise ValueError('square must be between 0 and 64')
