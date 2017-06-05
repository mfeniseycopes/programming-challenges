;; 2D Arrays
;;
;; https://www.hackerrank.com/challenges/30-2d-arrays

(use '[clojure.string :only (split triml)])

(defn parseInt [s] (Integer/parseInt s))

(def two-d
  (vec (repeatedly 6
                   #(mapv parseInt (clojure.string/split (read-line) #" ")))))

(defn hourglass-sum [arr k]
  (let [i (quot k 4) j (mod k 4) ]
    (+  (get-in arr [i j])
       (get-in arr [i (+ j 1)])
       (get-in arr [i (+ j 2)])
       (get-in arr [(+ i 1) (+ j 1)])
       (get-in arr [(+ i 2) j])
       (get-in arr [(+ i 2) (+ j 1)])
       (get-in arr [(+ i 2) (+ j 2)]))))

(defn hourglass-max [arr]
  (apply max (map (partial hourglass-sum arr) (range 16))))

(println (hourglass-max two-d))
