def flatten(items):
  flattened = list()

  for item in items:
    if item is None:
      continue
    elif _is_iterable(item):
      flattened.extend(flatten(item))
    else:
      flattened.append(item)

  return flattened

def _is_iterable(item):
  return hasattr(item, '__iter__') and not isinstance(item, (str, bytes))
