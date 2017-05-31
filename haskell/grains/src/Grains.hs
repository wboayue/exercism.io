module Grains (square, total) where

import Data.Maybe

square :: Integer -> Maybe Integer
square n
  | n `elem` [1..64] = Just (2 ^ (n - 1))
  | otherwise        = Nothing

total :: Integer
total = sum $ mapMaybe square [1..64]
