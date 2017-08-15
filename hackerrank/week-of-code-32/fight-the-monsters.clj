;; Fight the Monsters
;;
;; https://www.hackerrank.com/contests/w32/challenges/fight-the-monsters

(use '[clojure.string :only (split triml)])

(defn fight-the-monsters
  [hit times enemies]
  (loop [i 0 kills 0 [weakest & remaining-enemies] (sort enemies)]
    (if (< i times)
      (recur
        (inc i)
        (if (<= weakest hit) (inc kills) kills)
        (if (<= weakest hit) remaining-enemies (conj remaining-enemies (- weakest hit))))
      kills)))

(let [n_temp (read-line)
      n_t (split n_temp #"\s+")
      n (Integer/parseInt (n_t 0))
      hit (Integer/parseInt (n_t 1))
      t (Integer/parseInt (n_t 2))]
  (let [e_temp (read-line)
        e_t (split e_temp #"\s+")
        e (map #(Integer/parseInt %) e_t)]
    (println (fight-the-monsters hit t e))))

