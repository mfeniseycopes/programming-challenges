;; String-o-Permute
;;
;; https://www.hackerrank.com/challenges/string-o-permute

(use '[clojure.string :only (join)])
(def T (Integer/parseInt (read-line)))

(defn permute [s]
  (join (map #(join (reverse %)) (partition 2 s))))

(dotimes [n T]
  (println (permute (read-line))))


