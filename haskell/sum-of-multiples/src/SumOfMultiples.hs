module SumOfMultiples (sumOfMultiples) where

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum $ filter isMultiple [1 .. pred limit]
  where
    isMultiple x = any (\factor -> mod x factor == 0) factors
