from calendar import Calendar
from functools import partial

weekday_to_ord = {'Monday': 0, 'Tuesday': 1, 'Wednesday': 2, 'Thursday': 3, 'Friday': 4, 'Saturday': 5, 'Sunday': 6}

def matching_weekdays(year, month, weekday):
  return [date
          for date in Calendar().itermonthdates(year, month)
          if date.month == month and date.weekday() == weekday_to_ord[weekday]]

def meetup_day(year, month, weekday, schedule):
  def nth(n, dates):
    return dates[n]

  def last(dates):
    return dates[-1]

  def teenth(dates):
    return next(date for date in dates if date.day in range(13, 20))

  select_day = {
      '1st': partial(nth, 0),
      '2nd': partial(nth, 1),
      '3rd': partial(nth, 2),
      '4th': partial(nth, 3),
      '5th': partial(nth, 4),
      'last': last,
      'teenth': teenth
  }

  return select_day[schedule](matching_weekdays(year, month, weekday))
