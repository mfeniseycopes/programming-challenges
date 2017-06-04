;; Day 8 - Dictionaries and Maps
;;
;; https://www.hackerrank.com/challenges/30-dictionaries-and-maps

(def N (Integer/parseInt (read-line)))

(defn read-hash [n]
  (loop [i 0 pairs {}]
    (if (< i n)
      (recur (inc i) (apply (partial assoc pairs) (clojure.string/split (read-line) #" ")))
      pairs)))

(def name-numbers (read-hash N))

(doseq [x (take-while identity (repeatedly read-line))]
  (println
    (if (contains? name-numbers x)
      (str x "=" (get name-numbers x))
      "Not found")))
