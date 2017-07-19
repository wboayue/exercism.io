from datetime import date
from calendar import monthrange

weekday_to_ord = {'Monday': 0, 'Tuesday': 1, 'Wednesday': 2, 'Thursday': 3, 'Friday': 4, 'Saturday': 5, 'Sunday': 6}

def first_day(year, month, weekday):
  first_weekday, _last_day = monthrange(year, month)
  return 1 + ((weekday_to_ord[weekday] - first_weekday) % 7)

def matching_weekdays(year, month, weekday):
  current_day = first_day(year, month, weekday)
  _first_weekday, last_day = monthrange(year, month)

  results = []

  while current_day <= last_day:
    results.append(date(year, month, current_day))
    current_day += 7

  return results

def meetup_day(year, month, weekday, schedule):
  select_day = {
      '1st': lambda dates: dates[0],
      '2nd': lambda dates: dates[1],
      '3rd': lambda dates: dates[2],
      '4th': lambda dates: dates[3],
      '5th': lambda dates: dates[4],
      'last': lambda dates: dates[-1],
      'teenth': lambda dates: next(date for date in dates if date.day in range(13, 20))
  }

  return select_day[schedule](matching_weekdays(year, month, weekday))
