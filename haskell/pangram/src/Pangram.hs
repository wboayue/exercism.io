module Pangram (isPangram) where

import qualified Data.Set as S
import Data.Char (toLower)

isPangram :: String -> Bool
isPangram text = alphabet `S.isSubsetOf` sentence
  where
    alphabet = S.fromAscList(['a'..'z'])
    sentence = S.fromList $ map toLower text
