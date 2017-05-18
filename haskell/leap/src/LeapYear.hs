module LeapYear (isLeapYear) where

isLeapYear :: Integer -> Bool
isLeapYear year
  | divisibleBy year 400 = True
  | divisibleBy year 100 = False
  | divisibleBy year 4 = True
  | otherwise = False

divisibleBy :: Integer -> Integer -> Bool
divisibleBy x y = rem x y == 0
