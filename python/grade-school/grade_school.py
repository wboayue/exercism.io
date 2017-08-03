from collections import defaultdict, OrderedDict

class School(object):
  def __init__(self, name):
    self._name = name
    self._roster = defaultdict(set)

  def add(self, student, grade):
    self._roster[grade].add(student)

  def grade(self, num):
    return set(self._roster[num])

  def sort(self):
    return OrderedDict((grade, tuple(sorted(students))) for grade, students in self._roster.items())
