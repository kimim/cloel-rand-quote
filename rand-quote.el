(require 'cloel)

(defvar cloel-rand-quote-dir (file-name-directory load-file-name))

(cloel-register-app "rand-quote" cloel-rand-quote-dir "cloel")

(defun cloel-rand-quote-request ()
  "Send random quote request to Clojure process."
  (insert (cloel-rand-quote-call-sync 'rand-quote/get-quote)))

(defun cloel-rand-quote-start-process-confirm (client-id)
  (message "Start process confirm: %s" client-id)
  (cloel-rand-quote-request))

;;;###autoload
(defun rand-quote ()
  (interactive)
  (let* ((app-data (cloel-get-app-data "rand-quote"))
         (server-process (plist-get app-data :server-process)))
    (if (and server-process (process-live-p server-process))
        (cloel-rand-quote-request)
      (cloel-rand-quote-start-process))))

(provide 'rand-quote)
;;; cloel-rand-quote.el ends here
