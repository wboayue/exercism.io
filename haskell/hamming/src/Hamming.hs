module Hamming (distance) where

distance :: String -> String -> Maybe Int
distance xs ys = hamming xs ys 0

hamming :: String -> String -> Int -> Maybe Int
hamming [] [] d         = Just d
hamming (x:xs) (y:ys) d = hamming xs ys (if x == y then d else d + 1)
hamming _ _ _           = Nothing
