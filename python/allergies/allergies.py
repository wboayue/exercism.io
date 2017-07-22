class Allergies(object):
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

  def __init__(self, allergens):
    self._allergens = allergens
    self.lst = [item
                for item in self.ITEMS.keys()
                if self.is_allergic_to(item)]

  def is_allergic_to(self, item):
    return bool(self._allergens & self.ITEMS[item])
