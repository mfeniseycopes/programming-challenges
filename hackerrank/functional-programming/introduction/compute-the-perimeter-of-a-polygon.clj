;; Compute the Perimeter of a Polygon 
;;
;; https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon

(use '[clojure.string :only (split)])

(defn to-num [n](Long/parseLong n))
(defn dist [[x1 y1] [x2 y2]] (Math/hypot (- x1 x2) (- y1 y2)))

(defn pairs
  [col]
  (conj (partition 2 1 col) [(first col) (peek col)]))

(defn perimeter
  [coordinates]
  (apply + (map (partial apply dist) (pairs coordinates))))

(def N (to-num (read-line)))
(def P (vec (for [n (range N)] (map to-num (split (read-line) #" ")))))

(println (perimeter P))
