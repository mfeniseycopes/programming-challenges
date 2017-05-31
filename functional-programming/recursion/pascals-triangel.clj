;; Pascal's Triangle
;;
;; https://www.hackerrank.com/challenges/pascals-triangle

(def N (Integer/parseInt (read-line)))

(defn from-prev [i prev-row]
  (+ (or (get prev-row i) 0) (or (get prev-row (dec i)) 0)))

(defn print-pascal [rows]
  (loop [k 1 prev-row [1]]
    (println (clojure.string/join #" " prev-row))
    (if (not= k rows)
      (recur (inc k) (vec (map #(from-prev % prev-row) (range (inc k))))))))

(print-pascal N)
