;; Compute the Perimeter of a Polygon 
;;
;; https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon

(defn read-line-nums
  []
  (map #(Integer/parseInt %) ((comp #(clojure.string/split % #" ") read-line))))

(defn read-tuples
  [n]
  (loop [i 0 tuples []]
    (if (< i n)
      (recur (inc i) (conj tuples (read-line-nums)))
      tuples)))

(defn distance
  [[[a-x a-y] [b-x b-y]]]
  (Math/sqrt (+ (Math/pow (- a-y b-y) 2) (Math/pow (- a-x b-x) 2))))

(defn perimeter
  [[start & _ :as coordinates]]
  (loop
    [sum 0 remaining coordinates]
    (let [pair (take 2 remaining)]
      (if (= (count pair) 1)
        (+ sum (distance (conj pair start)))
        (recur
          (+ sum (distance pair))
          (rest remaining))))))

(println (perimeter (read-tuples (first (read-line-nums)))))

