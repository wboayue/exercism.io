module Acronym (abbreviate) where

import Data.Char

abbreviate :: String -> String
abbreviate xs = map toUpper $ fst $ foldl abbreviate' ("", Nothing) xs

abbreviate' :: (String, Maybe Char) -> Char -> (String, Maybe Char)
abbreviate' (abbreviation, Nothing) x = (abbreviation ++ [x], Just x) 
abbreviate' (abbreviation, Just last) x
  | isBreakpoint = (abbreviation ++ [x], Just x) 
  | otherwise    = (abbreviation, Just x) 
  where 
    isBreakpoint
      | isSpace last || isHyphen last = True
      | isUpper x && isLower last     = True
      | otherwise                     = False
    isHyphen x = last == '-'