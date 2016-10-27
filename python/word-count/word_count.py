# -*- coding: utf-8 -*-
import re
from collections import Counter

def word_count(sentence):
  words = re.split(ur"[\s_.,!&@$%^&:🖖]+", unicode(sentence.lower(), 'utf-8'), re.UNICODE)
  words = [ word for word in words if word != '' ]
  return dict(Counter(words))