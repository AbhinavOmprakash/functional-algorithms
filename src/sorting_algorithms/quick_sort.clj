(ns sorting-algorithms.quick-sort)

(defn- remove-at [nth coll]
  (let [[left right] (split-at (- nth 1) coll)]
    (concat left (rest right))))

(defn sort [coll]
  (if (< (count coll) 2)
    coll
    (let [mid (/ (count coll) 2)
          [pivot] (drop (- mid 1) coll)
          coll* (remove-at mid coll)]
      (lazy-cat (sort (filter #(<= % pivot) coll*))
                [pivot]
                (sort (filter #(> % pivot) coll*))))))
