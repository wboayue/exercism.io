module Bob (responseFor) where

import Data.Char

responseFor :: String -> String
responseFor xs
  | yell      = "Whoa, chill out!"
  | question  = "Sure."
  | silence   = "Fine. Be that way!"
  | otherwise = "Whatever."
  where
    yell     = (any isAlpha xs) && (map toUpper xs) == xs
    question = not (null stripped) && last stripped == '?' 
    silence  = all isSpace xs
    stripped = dropWhileEnd isSpace xs
