from datetime import date
from calendar import monthrange

week_days = { 'Monday': 0, 'Tuesday': 1, 'Wednesday': 2, 'Thursday': 3, 'Friday': 4, 'Saturday': 5, 'Sunday': 6 }

def first_day(year, month, week_day):
  first_day_of_month = date(year=year, month=month, day=1)
  days_between = (week_days[week_day] - first_day_of_month.weekday()) % 7
  return first_day_of_month.replace(day=1 + days_between)

def weekdays(year, month, week_day):
  first = first_day(year, month, week_day)
  day = first.day
  wd, last_day = monthrange(year, month)

  while day <= last_day:
    yield first.replace(day=day)
    day += 7

scheduler = {
  '1st': lambda x: x[0],
  '2nd': lambda x: x[1],
  '3rd': lambda x: x[2],
  '4th': lambda x: x[3],
  '5th': lambda x: x[4],
  'last': lambda x: x[-1],
  'teenth': lambda dates: [date for date in dates if date.day in range(13, 20)][0],
}

def meetup_day(year, month, week_day, schedule):
  return scheduler[schedule](list(weekdays(year, month, week_day)))
