module RunLength (decode, encode) where

import Data.List
import Data.Char

decode :: String -> String
decode "" = ""
decode encodedText = fst $ foldl decodeRun ("", 1) $ groupBy areDigits encodedText
  where
    areDigits x y = isDigit(x) && isDigit(y)
    decodeRun (decoded, n) x
      | any isDigit x = (decoded, read x :: Int)
      | otherwise     = (decoded ++ replicate n (x !! 0), 1)

encode :: String -> String
encode "" = ""
encode text = foldl encodeRun [] $ group text
  where
    encodeRun x acc = "a"
