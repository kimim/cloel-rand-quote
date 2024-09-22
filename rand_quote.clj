(ns random-quote
  (:require [cloel :as cloel]
            [faker.quote :as q]))

(defn rand-quote-start-process-confirm [data]
  (cloel/elisp-eval-async "cloel-rand-quote-start-process-confirm" (str data)))

(defn rand-quote-handle-client-connected [client-id]
  (rand-quote-start-process-confirm client-id))

(defn rand-quote-handle-client-message [data]
  (when (= data "quote")
    (future
      (cloel/elisp-eval-async "cloel-rand-quote-confirm"))))

(alter-var-root #'cloel/handle-client-message (constantly rand-quote-handle-client-message))
(alter-var-root #'cloel/handle-client-connected (constantly rand-quote-handle-client-connected))

(cloel/start-server (Integer/parseInt (first *command-line-args*)))
