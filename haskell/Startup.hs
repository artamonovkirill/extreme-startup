module Main where

import Happstack.Server (nullConf, logMAccess, simpleHTTP, toResponse, ok, look, ServerPart, queryString)

query :: ServerPart String
query =
    do q <- queryString $ look "q"
       ok $ respond $ q

respond :: String -> String
respond _ = "Ola!"

main :: IO ()
main = simpleHTTP nullConf $ query