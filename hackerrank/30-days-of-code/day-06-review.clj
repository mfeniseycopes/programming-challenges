;; Let's Review
;;
;; https://www.hackerrank.com/challenges/30-review-loop

(defn odd-even-str [s]
  (apply map str (partition 2 2 (repeat nil) s)))

(def T (Integer/parseInt (read-line)))

(dotimes [n 2] 
  (println (clojure.string/join #" " (odd-even-str (read-line)))))
