;; Day 2: Operators
;;
;; https://www.hackerrank.com/challenges/30-operators

(defn total-cost
    [meal tax tip]
      (Math/round (+ meal (* meal tax 0.01) (* meal tip 0.01))))

(let [meal (Double/parseDouble (read-line))
            tax (Integer/parseInt (read-line))
                  tip (Integer/parseInt (read-line))]
    (println "The total meal cost is" (total-cost meal tax tip) "dollars."))
