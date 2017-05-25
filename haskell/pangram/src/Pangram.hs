module Pangram (isPangram) where

import Data.Char (toLower)

isPangram :: String -> Bool
isPangram text = all hasLetter alphabet
  where
    alphabet    = ['a'..'z']
    hasLetter x = any ((==) x) $ map toLower text