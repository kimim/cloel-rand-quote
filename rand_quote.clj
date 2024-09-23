(ns random-quote
  (:require [cloel :as cloel]
            [faker.quote :as q]))

(defn rand-quote-start-process-confirm [data]
  (cloel/elisp-eval-async "cloel-rand-quote-start-process-confirm" (str data)))

(defn rand-quote-handle-client-connected [client-id]
  (rand-quote-start-process-confirm client-id))

(alter-var-root #'cloel/handle-client-connected (constantly rand-quote-handle-client-connected))

(cloel/start-server (Integer/parseInt (first *command-line-args*)))
