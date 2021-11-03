(ns sorting-algorithms.selection-sort)


(defn- remove-
  "Removes only first element that returns true for pred"
  [pred coll]
  (let [[left right] (split-with (complement pred) coll)]
    (concat left (rest right))))

(defn sort
  "Simple sort."
  ([coll] (sort coll []))
  ([coll sorted]
   (if (empty? coll)
     sorted
     (let [smallest (apply min coll)
           coll* (remove- #{smallest} coll)]
       (recur coll* (concat sorted [smallest]))))))