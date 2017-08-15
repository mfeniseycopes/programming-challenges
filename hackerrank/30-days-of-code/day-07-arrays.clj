;; Arrays
;;
;; https://www.hackerrank.com/challenges/30-arrays

(use '[clojure.string :only (split triml)])

(def N (Integer/parseInt (read-line)))
(def A (split (read-line) #" "))

(apply print (reverse A))
