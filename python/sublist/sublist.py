SUBLIST, SUPERLIST, EQUAL, UNEQUAL = ('SUBLIST', 'SUPERLIST', 'EQUAL', 'UNEQUAL')


def check_lists(first, second):
    if first == second:
      return EQUAL
    elif _sublist(first, second):
      return SUBLIST
    elif _sublist(second, first):
      return SUPERLIST

    return UNEQUAL


def _sublist(first, second):
    chunks = (second[i:i+len(first)] for i in range(len(second)-len(first)+1))
    return any(chunk == first for chunk in chunks)