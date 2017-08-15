;; Fibonacci Numbers
;;
;; https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers

(defn fib [N]
  (loop [k 1 prev-pair [0 1]]
    (if (= k N)
      (first prev-pair)
      (recur (inc k) [(last prev-pair) (apply + prev-pair)]))))


(def N (Integer/parseInt (read-line)))

(println (fib N))
