module LeapYear (isLeapYear) where

isLeapYear :: Integer -> Bool
isLeapYear year
  | isDivisibleBy year 400 = True
  | isDivisibleBy year 100 = False
  | isDivisibleBy year 4 = True
  | otherwise = False
  where
    isDivisibleBy x y = rem x y == 0
