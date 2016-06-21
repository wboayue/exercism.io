var Year = function(year) {
  this.year = year;
};

var LEAP_YEAR = true,
    COMMON_YEAR = false;

var isDivisibleBy = function isDivisibleBy(year, denominator) {
  return year % denominator == 0
}

Year.prototype.isLeap = function() {
  if (!isDivisibleBy(this.year, 4)) {
    return COMMON_YEAR;
  } else if (!isDivisibleBy(this.year, 100)) {
    return LEAP_YEAR;
  } else if (!isDivisibleBy(this.year, 400)) {
    return COMMON_YEAR;
  } else {
    return LEAP_YEAR;
  }
};

module.exports = Year;
