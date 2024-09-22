(require 'cloel)

(defvar cloel-rand-quote-clj-file (expand-file-name "rand_quote.clj" (file-name-directory load-file-name)))

(cloel-register-app "rand-quote" cloel-rand-quote-clj-file)

(defun cloel-rand-quote ()
  (interactive)
  ;; STEP 1: Start Clojure process with localhost and free port.
  (cloel-rand-quote-start-process))

(defun cloel-rand-quote-start-process-confirm (client-id)
  (message "Start process confirm: %s" client-id)
  (cloel-rand-quote-send-message "quote"))

(defun cloel-rand-quote-confirm ()
  (insert (cloel-rand-quote-call-sync "q/rand-quote")))
