(ns search-algorithms.binary-search)

(defn search [v x]
  (when (seq v)
    (if-not (apply <= v)
      (recur (vec (sort  v)) x)
      (let [mid-idx (quot (count v) 2)
            mid-el (get v mid-idx)]
        (cond
          (= mid-el x) x

          ; adding 1 to mid-idx is necessary 
          ; because mid-idx will become 0 at some point and 
          ; drop 0 will always return a non-empty seq
          (< mid-el x)
          (recur (vec (drop (+ 1 mid-idx) v)) x)

          (> mid-el x)
          (recur (vec (take mid-idx v)) x))))))


