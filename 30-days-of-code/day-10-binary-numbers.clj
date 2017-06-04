;; Day 10 - Binary Numbers
;;
;; https://www.hackerrank.com/challenges/30-binary-numbers

(def X (Integer/parseInt (read-line)))

(defn ones [x]
  (loop [k x running 0 maximum 0]
    (if (zero? k)
      maximum
      (if-not (zero? (bit-and k 1))
        (recur (quot k 2) (inc running) (max (inc running) maximum))
        (recur (quot k 2) 0 maximum)))))

(println (ones X))
