# -*- coding: utf-8 -*-
from datetime import timedelta

GIGA_SECOND = 1000000000

def add_gigasecond(date_time):
  return date_time + timedelta(seconds=GIGA_SECOND)
