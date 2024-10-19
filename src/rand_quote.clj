(ns rand-quote
  (:require [cloel :as cloel]
            [faker.quote :as q]))

(defn rand-quote-start-process-confirm [data]
  (cloel/elisp-eval-async "cloel-rand-quote-start-process-confirm" (str data)))

(defn rand-quote-handle-client-connected [client-id]
  (rand-quote-start-process-confirm client-id))

(defn get-quote []
  (q/rand-quote))

(alter-var-root #'cloel/handle-client-connected (constantly rand-quote-handle-client-connected))

(defn -main [& args]
  (cloel/start-server (Integer/parseInt (last args))))
