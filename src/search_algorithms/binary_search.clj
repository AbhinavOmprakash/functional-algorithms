(ns search-algorithms.binary-search)

(defn search [v x]
  (when (seq v)
    (if-not (apply <= v)
      (recur (vec (sort  v)) x)
      (let [count* (count v)
            mid-idx (quot count* 2)
            mid-el (get v mid-idx)]
        (cond
          (= mid-el x) x

          (< mid-el x)
          (recur (subvec v (+ 1 mid-idx) count*) x)

          (> mid-el x)
          (recur (subvec v 0 mid-idx) x))))))


