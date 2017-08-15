;; Computing the GCD
;;
;; https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd

(defn gcd [a b]
  (loop [x a y b]
    (cond (> x y) (recur y x)
          (zero? (mod y x)) x
          :else (recur (- y x) x))))

(def ab (map read-string (re-seq #"\d+" (read-line))))

(println (apply gcd ab))
