;; Compute the Area of a Polygon
;;
;; https://www.hackerrank.com/challenges/lambda-march-compute-the-area-of-a-polygon

(use '[clojure.string :only (split)])

(defn to-num [n](Long/parseLong n))

(defn pairs
  [col]
  (conj (partition 2 1 col) (list (peek col) (first col))))

(defn pair-sum [[xi yi] [xj yj]] (- (* xi yj) (* xj yi)))

(defn area [coordinates]
  (double (/ (Math/abs (apply + (map (partial apply pair-sum) (pairs coordinates)))) 2)))

(def N (to-num (read-line)))
(def P (vec (for [n (range N)] (map to-num (split (read-line) #" ")))))

(println (area P))

