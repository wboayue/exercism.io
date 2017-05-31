module Grains (square, total) where

import Data.Bits

square :: Integer -> Maybe Integer
square n
  | n < 1 || n > 64 = Nothing
  | otherwise       = Just (grains n)

grains :: Integer -> Integer
grains n = 2 ^ (n - 1)

total :: Integer
total = sum $ map grains [1..64]
