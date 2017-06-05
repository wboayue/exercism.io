module Hamming (distance) where

distance :: String -> String -> Maybe Int
distance xs ys = hamming xs ys 0

hamming :: String -> String -> Int -> Maybe Int
hamming [] [] d = Just d
hamming _  [] _ = Nothing
hamming [] _  _ = Nothing
hamming (x:xs) (y:ys) d
  | x == y    = hamming xs ys d
  | otherwise = hamming xs ys (d + 1)
