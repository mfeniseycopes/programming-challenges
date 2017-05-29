;; Day 3: Intro to Conditional Statements
;;
;; https://www.hackerrank.com/challenges/30-conditional-statements
(use '[clojure.string :only (split triml)])

(defn wierd? [N]
  (or (odd? N) (<= 6 N 20)))

(def N (Integer/parseInt (read-line)))

(println (if (wierd? N) "Weird" "Not Weird"))
