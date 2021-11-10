(ns sorting-algorithms.merge-sort)

(defn- merge
  ([coll] coll)
  ([coll1 coll2] (merge coll1 coll2 []))
  ([coll1 coll2 result]
   (if (some empty? [coll1 coll2])
         (lazy-cat result coll1 coll2)
         (let [[f1] coll1
               [f2] coll2]
           (if (<= f1 f2)
             (recur (rest coll1) coll2 (lazy-cat result [f1]))
             (recur coll1 (rest coll2) (lazy-cat result [f2])))))))

(defn- sort-helper [coll]
; if its a nested list of one element that means 
; all elements have been merged and sorted. 
; flatten  
  (if (= (count coll) 1) 
    (flatten coll)
    (->> coll
         (partition-all 2)
         (map #(apply merge %))
         (recur))))

;; Bottom up merge sort.
(defn sort
  ([coll]
   ;; start with a seq of 1-element vectors
   (sort-helper (map vector coll))))