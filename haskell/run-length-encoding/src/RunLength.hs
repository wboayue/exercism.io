module RunLength (decode, encode) where

import Data.List
import Data.Char

decode :: String -> String
decode = fst . foldl decodeText ("", 1) . groupBy isConsecutiveDigits
  where
    isConsecutiveDigits x y = isDigit(x) && isDigit(y)
    decodeText (decoded, n) x
      | any isDigit x = (decoded, read x :: Int)
      | otherwise     = (decoded ++ replicate n (x !! 0), 1)

encode :: String -> String
encode = foldl encodeRun "" . group
  where
    encodeRun encoded (x:[]) = encoded ++ [x]
    encodeRun encoded run = encoded ++ show (length run) ++ [(run !! 0)]
