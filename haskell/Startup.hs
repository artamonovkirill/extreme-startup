module Main where

import Happstack.Server (nullConf, simpleHTTP, ok, look, ServerPart, queryString)
import Control.Monad.Trans (liftIO)

query :: ServerPart String
query =
    do q <- queryString $ look "q"
       liftIO $ putStrLn $ "Query is: " ++ q
       ok $ respond $ q

respond :: String -> String
respond _ = "Ola!"

main :: IO ()
main = simpleHTTP nullConf $ query