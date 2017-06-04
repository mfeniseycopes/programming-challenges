;; Day 5: Loops
;;
;; https://www.hackerrank.com/challenges/30-loops

(use '[clojure.string :only (split triml)])

(def N (Integer/parseInt (read-line)))

(defn factor [n k]
  (str n " x " k " = " (* n k)))

(defn factors [n]
  (dotimes [k 10]
    (println (factor n (inc k)))))

(factors N)
