# cloel-rand-quote

Generating random quote and insert to Emacs.

Since this plugin is developed based on [cloel](https://github.com/manateelazycat/cloel), it can fully utilize Clojure's multi-threading capabilities, ensuring that Emacs won't freeze even when processing large files.

## Installation

1. Install [cloel](https://github.com/manateelazycat/cloel)

2. Install cloel-rand-quote
   - Clone the repository and add it to your Emacs configuration:

   ```elisp
   (add-to-list 'load-path "<path-to-cloel-rand-quote>")
   (require 'cloel-rand-quote)
   ```

## Usage
M-x `cloel-rand-quote`
