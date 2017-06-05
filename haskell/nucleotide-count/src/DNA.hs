module DNA (nucleotideCounts) where

import Data.Map (Map, fromList, keys, insertWith)

initialCounts :: Map Char Int
initialCounts = fromList [ ('A', 0), ('C', 0), ('G', 0), ('T', 0) ]

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts xs = if isValidNucleotide
                      then Right $ foldl addToCounts initialCounts xs
                      else Left "invalid nucleotide."
  where
    addToCounts counts x = insertWith (+) x 1 counts
    isValidNucleotide    = all (`elem` keys initialCounts) xs

