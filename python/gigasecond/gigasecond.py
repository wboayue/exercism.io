# -*- coding: utf-8 -*-
from datetime import timedelta

def add_gigasecond(date_time):
  return date_time + timedelta(seconds=10**9)
