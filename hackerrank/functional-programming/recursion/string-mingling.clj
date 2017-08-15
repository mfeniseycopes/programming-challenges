;; String Mingling
;;
;; https://www.hackerrank.com/challenges/string-mingling

(def P (read-line))
(def Q (read-line))

(defn mingle [p q]
  (loop [i 0 mingled []]
    (if (< i (count p))
      (recur (inc i) (conj mingled (get p i) (get q i)))
      mingled)))

(println (apply str (mingle P Q)))
