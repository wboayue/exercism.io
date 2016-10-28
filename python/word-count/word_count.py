# -*- coding: utf-8 -*-
import re
from collections import Counter

SPLIT_RE = re.compile(r'[\W_]+', re.UNICODE)

def words(sentence):
  words = SPLIT_RE.split(unicode(sentence, 'utf-8').lower())
  return [ word for word in words if word != '' ]

def word_count(sentence):
  return dict(Counter(words(sentence)))