;; Functions or Not?
;;
;; https://www.hackerrank.com/challenges/functions-or-not

(defn read-line-nums
  []
  (map #(Integer/parseInt %) ((comp #(clojure.string/split % #" ") read-line))))

(dotimes [t (first (read-line-nums))]
  (loop [n (first (read-line-nums)) xs #{}]
    (if (zero? n)
      (println "YES")
      (let [[x y] (read-line-nums)]
        (if (contains? xs x)
          (println "NO")
          (recur (dec n) (conj xs x)))))))
