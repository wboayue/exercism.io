module Pangram (isPangram) where

import Data.Char

isPangram :: String -> Bool
isPangram "" = False
isPangram text = all (\x -> elem x lowerCaseText) ['a'..'z']
  where lowerCaseText = map toLower text

