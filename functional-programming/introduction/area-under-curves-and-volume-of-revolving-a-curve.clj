;; Area Under Curves and Volume of Revolving a Curve
;;
;; https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv

; Enter your code here. Read input from STDIN. Print output to STDOUT
(defn read-line-nums
  []
  (map #(Integer/parseInt %) ((comp #(clojure.string/split % #" ") read-line))))

(defn expr
  [a b]
  (fn [x]
    (apply + (map #(* %1 (Math/pow x %2)) a b))))

(defn circle-area
  [r]
  (* Math/PI (Math/pow r 2)))

(defn vol
  [f l r int-size]
  (loop [x l sum 0]
    (if (> x r)
      sum
      (recur (+ x int-size) (+ sum (* (circle-area (f x)) int-size))))))

(defn area
  [f l r int-size]
  (loop [x (+ l int-size) sum 0]
    (if (> x r)
      sum
      (recur (+ x int-size) (+ sum (* (f x) int-size))))))

(let [a (read-line-nums)
      b (read-line-nums)
      [l r] (read-line-nums)]
  (println (format "%.1f" (area (expr a b) l r 0.001)))
  (println (format "%.1f" (vol (expr a b) l r 0.001))))
