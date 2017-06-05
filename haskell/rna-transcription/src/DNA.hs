module DNA (toRNA) where

toRNA :: String -> Maybe String
toRNA xs = if isValid xs
            then Just (map convert xs)
            else Nothing
  where
    isValid x = all (`elem` "GCTA") xs
    convert x = case x of
                    'G' -> 'C'
                    'C' -> 'G'
                    'T' -> 'A'
                    'A' -> 'U'
