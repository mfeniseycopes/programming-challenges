;; - Circulular Walk
;;
;; https://www.hackerrank.com/contests/w32/challenges/circular-walk

(use '[clojure.string :only (split triml)])

(defn next-recurrence
  [prev g seed p]
  (mod (+ (* prev g) seed) p))

(defn recurrence-nodes
  [n r0 g seed p]
  (loop [i 1
         nodes [{:r r0
                 :visited false
                 :hops 0 }]]
    (if (< i n)
      (recur
        (inc i)
        (conj nodes
              {:r (next-recurrence (:r (last nodes)) g seed p)
               :visited false }))
      nodes)))

(defn visited?
  [nodes i]
  (get-in nodes [i :visited]))

(defn neighbors
  [nodes i]
  (let [r (get-in nodes [i :r])]
    (range (- i r) (+ i r))))

(defn unvisited-neighbors
  [nodes i]
  (filter #(not (visited? nodes %)) (neighbors nodes i)))

(defn hops
  [nodes i]
  (get-in nodes [i :hops]))

(defn circular-walk
  [r-nodes start dest]
  (loop [[head & remaining :as queue] [{ :val start :hops 0 }]
         nodes r-nodes]
    (cond
      (empty? queue) -1
      (= (:val head) dest) (:hops head)
      :else
      (let [potentials (unvisited-neighbors nodes (:val head))]
        (recur
          (into remaining
                (map #(hash-map :val :hops (inc (:hops head))) potentials))
          (reduce #(assoc-in %1 [%2 :visited] true) nodes potentials))))))

(let [n_temp (read-line)
      n_t (split n_temp #"\s+")
      n (Integer/parseInt (n_t 0))
      s (Integer/parseInt (n_t 1))
      t (Integer/parseInt (n_t 2))]
  (let [r_0_temp (read-line)
        r_0_t (split r_0_temp #"\s+")
        r_0 (Integer/parseInt (r_0_t 0))
        g (Integer/parseInt (r_0_t 1))
        seed (Integer/parseInt (r_0_t 2))
        p (Integer/parseInt (r_0_t 3))]
    (circular-walk (recurrence-nodes n r_0 g seed p) s t)))
