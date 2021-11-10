(ns sorting-algorithms.bubble-sort)

(defn- bubble-step
  "The bubble swap step."
  [v idx1 idx2]
  (let [x1 (get v idx1)
        x2 (get v idx2)
        left-v (subvec v 0 idx1)
        right-v (subvec v (inc idx2))]
    (if (<= x1 x2)
      (vec (concat left-v [x1 x2] right-v))
      (vec (concat left-v [x2 x1] right-v)))))

(defn- pass-once 
"Passes through the vector once, swapping elements."
  [v]
  (loop [v* v
         idx1 0
         idx2 1]
    (if (< (count v*) (inc idx2)) ; we have reached the end of the vector
      v*
      (recur (bubble-step v* idx1 idx2)
             (inc idx1)
             (inc idx2)))))

(defn sort
  "Bubble sort for vectors."
  [v]
  (if (apply <= v)  ; test if sorted
    v
    (recur (pass-once v))))


(defn- bubble-step-seq [coll idx1 idx2]
  (let [x1 (nth coll idx1)
        x2 (nth coll idx2)
        left (take idx1 coll)
        right (drop (inc idx2) coll)]
    (if (<= x1 x2)
      (lazy-cat left [x1 x2] right)
      (lazy-cat left [x2 x1] right))))

(defn- pass-once-seq [coll]
  (loop [coll* coll
         idx1 0
         idx2 1]
    (if (< (count coll*) (inc idx2)) ; we have reached the end of the vector
      coll*
      (recur (bubble-step-seq coll* idx1 idx2)
             (inc idx1)
             (inc idx2)))))

(defn sort-seq
;; very inefficient
  "Bubble sort for any clojure sequence."
  [coll]
  (if (apply <= coll)
    coll
    (recur (pass-once-seq coll))))