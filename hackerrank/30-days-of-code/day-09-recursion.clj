;; Day 9 - Recursion
;;
;; https://www.hackerrank.com/challenges/30-recursion

(def N (Integer/parseInt (read-line)))

(defn factorial [n]
  (loop [k n prod 1]
    (if (< k 2)
      prod
      (recur (dec k) (* prod k)))))

(println (factorial N))
