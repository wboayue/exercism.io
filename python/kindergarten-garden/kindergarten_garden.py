from itertools import chain

DEFAULT_STUDENTS = [
    'Alice', 'Bob', 'Charlie', 'David', 'Eve', 'Fred',
    'Ginny', 'Harriet', 'Ileana', 'Joseph', 'Kincaid', 'Larry'
]

PLANTS = {'G': 'Grass', 'C': 'Clover', 'R': 'Radishes', 'V': 'Violets'}

class Garden(object):
  def __init__(self, cups, students=DEFAULT_STUDENTS):
    self._rows = cups.split('\n')
    self._students = sorted(students)

  def plants(self, child_name):
    plot_number = self._students.index(child_name)
    return [PLANTS[plant] for plant in self.plants_in_plot(plot_number)]

  def plants_in_plot(self, i):
    return chain.from_iterable(row[i*2:i*2+2] for row in self._rows)
