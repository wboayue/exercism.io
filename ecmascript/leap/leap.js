const LEAP_YEAR = true,
      COMMON_YEAR = false;

const isDivisibleBy = function isDivisibleBy(year, denominator) {
  return year % denominator == 0
}

const isLeapYear = function isLeapYear(year) {
  if (!isDivisibleBy(year, 4)) {
    return COMMON_YEAR;
  } else if (!isDivisibleBy(year, 100)) {
    return LEAP_YEAR;
  } else if (!isDivisibleBy(year, 400)) {
    return COMMON_YEAR;
  } else {
    return LEAP_YEAR;
  }
}

export default isLeapYear;
