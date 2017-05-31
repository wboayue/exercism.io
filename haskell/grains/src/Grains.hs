module Grains (square, total) where

import Data.Bits

square :: Integer -> Maybe Integer
square n
  | n `elem` [1..64] = Just (grains n)
  | otherwise        = Nothing

grains :: Integer -> Integer
grains n = 2 ^ (n - 1)

total :: Integer
total = sum $ map grains [1..64]
