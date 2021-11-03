(ns sorting-algorithms.insertion-sort)

(defn insert [coll x]
  (let [[left right] (split-with #(< % x) coll)]
    (concat left [x] right))) 

(defn sort [coll]
  (reduce insert [] coll))
