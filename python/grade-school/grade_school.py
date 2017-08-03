from collections import defaultdict, OrderedDict

class School(object):
  def __init__(self, name):
    self._name = name
    self._roster = defaultdict(list)

  def add(self, student, grade):
    self._roster[grade].append(student)

  def grade(self, num):
    return list(self._roster[num])

  def sort(self):
    return OrderedDict((grade, tuple(sorted(students))) for grade, students in sorted(self._roster.items()))
