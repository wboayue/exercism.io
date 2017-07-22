ITEMS = {
    'eggs':  1,
    'peanuts': 2,
    'shellfish': 4,
    'strawberries': 8,
    'tomatoes': 16,
    'chocolate': 32,
    'pollen': 64,
    'cats': 128
}

class Allergies(object):
  def __init__(self, allergens):
    self._allergens = allergens
    self.lst = [item
                for item in ITEMS.keys()
                if self.is_allergic_to(item)]

  def is_allergic_to(self, item):
    return self._allergens & ITEMS[item] > 0
