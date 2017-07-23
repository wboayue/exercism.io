def slices(series, slice_len):
  if slice_len == 0 or slice_len > len(series):
    raise ValueError("Invalid slice length")

  def slice_at(i):
    return [int(d) for d in series[i : i + slice_len]]

  return [slice_at(i) for i in xrange(len(series) - slice_len + 1)]
