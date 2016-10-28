# -*- coding: utf-8 -*-
from datetime import timedelta

GIGA_SECOND = timedelta(seconds=10**9)

def add_gigasecond(date_time):
  return date_time + GIGA_SECOND
