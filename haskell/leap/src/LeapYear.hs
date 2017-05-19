module LeapYear (isLeapYear) where

isLeapYear :: Integer -> Bool
isLeapYear year
  | isYearDivisibleBy 400 = True
  | isYearDivisibleBy 100 = False
  | isYearDivisibleBy 4 = True
  | otherwise = False
  where
    isYearDivisibleBy x = rem year x == 0
