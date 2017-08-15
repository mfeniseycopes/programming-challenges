;; Duplication
;;
;; https://www.hackerrank.com/contests/w32/challenges/duplication

(use '[clojure.string :only (split triml)])

(defn make-dup
  []
  (loop [current [false]]
    (if (< (count current) 1000)
      (recur (into current (map #(not %) current)))
      current)))

(def dup (make-dup))

(defn bool-to-bit
  [bool]
  (if bool 1 0))

(let [q_t (read-line) q (Integer/parseInt q_t)]
  (loop [a0 q]
    (when (> a0 0)
      (let [x_t (read-line) x (Integer/parseInt x_t)]
        (println (bool-to-bit (nth dup x)))
        (recur (- a0 1))))))

